package com.example.demo.sevices;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.demo.repository.EmployeeRepositoryImpl;
import com.example.demo.utils.ConnectionFactory;
import com.training.exceptions.EmployeeNotFoundException;
import com.training.ifaces.CrudRepository;
import com.training.ifaces.EmployeeRepository;
import com.training.model.Employee;

public class EmployeeService {
	Connection con;
	EmployeeRepository repo;
	private static final Logger logger = LogManager.getRootLogger();
	public EmployeeService() {
		super();
		this.con=ConnectionFactory.getMySqlConnection();
		this.repo=new EmployeeRepositoryImpl(con);
	}
	public void save(Employee obj) {
		 logger.error("is Employee Created:="+this.repo.save(obj));
	}
	public void findByFirstName(String firstName) throws EmployeeNotFoundException {
		Collection<Employee> employeeList=new ArrayList<>();
		employeeList=this.repo.findByFirstName(firstName);
		logger.error("List of employees who are having first name as: "+firstName);
		for (Employee employee : employeeList) {
			logger.error(employee);
		}
	}
	public void findFirstNameAndPhoneNumberOfAll() throws EmployeeNotFoundException {
		Map<String, Long>  employeeMap=new HashMap<>();
		employeeMap=this.repo.findFirstNameAndPhoneNumberOfAll();
		Set<Map.Entry<String,Long>> employeeSet=employeeMap.entrySet();
		logger.error("First name and PhoneNumber of all employees");
		employeeSet.forEach(e->System.out.println(e.getKey()+"::"+e.getValue()));
	}
	public void updateByEmailAndPhoneNumberOfAnEmployee(String updatedEmail, long phoneNumber, String email) {
		logger.error("Does an employee with email: "+email+" get updated:="+this.repo.updateByEmailAndPhoneNumberOfAnEmployee(updatedEmail, phoneNumber, email));
	}
	public void deleteByFirstName(String firstName, String email) throws EmployeeNotFoundException {
		logger.error("Does an employee with email: "+email+" get deleted:="+this.repo.deleteByFirstName(firstName, email));
	}
	public void findFirstNameAndEmailOfAllByBirthday(LocalDate dateOfBirth) throws EmployeeNotFoundException {
		Map<String, String>  employeeMap=new HashMap<>();
		employeeMap=this.repo.findFirstNameAndEmailOfAllByBirthday(dateOfBirth);
		Set<Map.Entry<String,String>> employeeSet=employeeMap.entrySet();
		logger.error("First name and Email of all employees who born on="+dateOfBirth);
		employeeSet.forEach(e->System.out.println(e.getKey()+"::"+e.getValue()));
	}
	public void findFirstNameAndPhoneNumberOfAllByWeddingDate(LocalDate weddingDate) throws EmployeeNotFoundException {
		Map<String, Long>  employeeMap=new HashMap<>();
		employeeMap=this.repo.findFirstNameAndPhoneNumberOfAllByWeddingDate(weddingDate);
		Set<Map.Entry<String,Long>> employeeSet=employeeMap.entrySet();
		logger.error("First name and PhoneNumber of all employees who got married on="+weddingDate);
		employeeSet.forEach(e->System.out.println(e.getKey()+"::"+e.getValue()));
	}
}
