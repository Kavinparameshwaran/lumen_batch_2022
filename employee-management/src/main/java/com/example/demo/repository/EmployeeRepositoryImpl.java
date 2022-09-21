package com.example.demo.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.training.exceptions.EmployeeNotFoundException;
import com.training.ifaces.CrudRepository;
import com.training.ifaces.EmployeeRepository;
import com.training.model.Employee;

public class EmployeeRepositoryImpl implements EmployeeRepository {

	private Connection con;

	public EmployeeRepositoryImpl(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public Collection<Employee> findAll() throws EmployeeNotFoundException {
		List<Employee> employeeList = new ArrayList<>();
		Employee employee;
		String sql = "select * from employee_management";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			ResultSet resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				employee = mapRowToObjectForAllColumns(resultSet);
				employeeList.add(employee);
				while (resultSet.next()) {
					employee = mapRowToObjectForAllColumns(resultSet);
					employeeList.add(employee);
				}
			} else {
				throw new EmployeeNotFoundException("ERR-101", "Employee is not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	@Override
	public boolean save(Employee obj) {
		String sql = "insert into employee_management values (?,?,?,?,?,?,?)";
		int rowUpdated = 0;
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, obj.getFirstName());
			pstmt.setString(2, obj.getLastName());
			pstmt.setString(3, obj.getAddress());
			pstmt.setString(4, obj.getEmail());
			pstmt.setLong(5, obj.getPhoneNumber());
			Date dateOfBirth = Date.valueOf(obj.getDateOfBirth());
			pstmt.setDate(6, dateOfBirth);
			Date weddingDate = Date.valueOf(obj.getWeddingDate());
			pstmt.setDate(7, weddingDate);
			rowUpdated = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowUpdated == 1 ? true : false;
	}

	@Override
	public Collection<Employee> findByFirstName(String firstName) throws EmployeeNotFoundException {
		Collection<Employee> employeeList = new ArrayList<>();
		employeeList = findAll().stream().filter(e -> e.getFirstName().equals(firstName)).collect(Collectors.toList());
		if (employeeList.isEmpty()) {
			throw new EmployeeNotFoundException("ERR-102", "Employee Not found with the given name: " + firstName);
		} else {
			return employeeList;
		}
	}

	@Override
	public Map<String, Long> findFirstNameAndPhoneNumberOfAll() throws EmployeeNotFoundException {
		Map<String, Long> employeeMap = new HashMap<>();
		employeeMap = findAll().stream().collect(Collectors.toMap(Employee::getFirstName, Employee::getPhoneNumber));
		if (employeeMap.isEmpty()) {
			throw new EmployeeNotFoundException("ERR_103", "No employees found");
		} else {
			return employeeMap;
		}
	}

	@Override
	public boolean updateByEmailAndPhoneNumberOfAnEmployee(String updatedEmail, long phoneNumber, String email) {
		String sql = "update employee_management SET email=?, phoneNumber=? where email=?";
		int rowUpdated = 0;
		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setString(1, updatedEmail);
			statement.setLong(2, phoneNumber);
			statement.setString(3, email);
			rowUpdated = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowUpdated == 1 ? true : false;
	}

	@Override
	public boolean deleteByFirstName(String firstName, String email) throws EmployeeNotFoundException {
		String query = "select * from employee_management where email=?";
		int rowDeleted = 0;
		try (PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.setString(1, email);
			ResultSet resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				String sql = "delete from employee_management where firstName=?";
				try (PreparedStatement statement = con.prepareStatement(sql)) {
					statement.setString(1, firstName);
					rowDeleted = statement.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				throw new EmployeeNotFoundException("ERR-105",
						" Particular Employee with name: " + firstName + " and email: " + email + " is not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowDeleted == 1 ? true : false;
	}

	@Override
	public Map<String, String> findFirstNameAndEmailOfAllByBirthday(LocalDate dateOfBirth)
			throws EmployeeNotFoundException {
		Map<String, String> employeeMap = new HashMap<>();
		employeeMap = findAll().stream()
				.filter(e -> e.getDateOfBirth().getMonth().equals(dateOfBirth.getMonth())
						&& e.getDateOfBirth().getDayOfMonth() == dateOfBirth.getDayOfMonth())
				.collect(Collectors.toMap(Employee::getFirstName, Employee::getEmail));
		if (employeeMap.isEmpty()) {
			throw new EmployeeNotFoundException("ERR_106",
					"Employees with birthday on " + dateOfBirth + "is not found");
		} else {
			return employeeMap;
		}

	}

	@Override
	public Map<String, Long> findFirstNameAndPhoneNumberOfAllByWeddingDate(LocalDate weddingDate)
			throws EmployeeNotFoundException {
		Map<String, Long> employeeMap = new HashMap<>();
		employeeMap = findAll().stream()
				.filter(e -> e.getWeddingDate().getMonth().equals(weddingDate.getMonth())
						&& e.getWeddingDate().getDayOfMonth() == weddingDate.getDayOfMonth())
				.collect(Collectors.toMap(Employee::getFirstName, Employee::getPhoneNumber));
		if (employeeMap.isEmpty()) {
			throw new EmployeeNotFoundException("ERR_107",
					"Employees with wedding date on" + weddingDate + "is not found");
		} else {
			return employeeMap;
		}
	}

	private Employee mapRowToObjectForAllColumns(ResultSet resultSet) throws SQLException {
		String firstName = resultSet.getString("firstName");
		String lastName = resultSet.getString("lastName");
		String address = resultSet.getString("address");
		String email = resultSet.getString("email");
		long phoneNumber = resultSet.getLong("phoneNumber");
		LocalDate dateOfBirth = resultSet.getDate("dateOfBirth").toLocalDate();
		LocalDate weddingDate = null;
		if (resultSet.getDate("weddingDate") != null) {
			weddingDate = resultSet.getDate("weddingDate").toLocalDate();
		}
		return new Employee(firstName, lastName, address, email, phoneNumber, dateOfBirth, weddingDate);
	}

}
