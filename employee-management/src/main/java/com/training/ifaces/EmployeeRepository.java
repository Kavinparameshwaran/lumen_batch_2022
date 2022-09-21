package com.training.ifaces;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

import com.training.exceptions.EmployeeNotFoundException;
import com.training.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee> {
	public Collection<Employee> findByFirstName(String firstName) throws EmployeeNotFoundException;

	public Map<String,Long> findFirstNameAndPhoneNumberOfAll() throws EmployeeNotFoundException;

	public boolean updateByEmailAndPhoneNumberOfAnEmployee(String updatedEmail, long phoneNumber, String email);

	public boolean deleteByFirstName(String firstName, String email) throws EmployeeNotFoundException;

	public Map<String,String> findFirstNameAndEmailOfAllByBirthday(LocalDate dateOfBirth)
			throws EmployeeNotFoundException;

	public Map<String,Long> findFirstNameAndPhoneNumberOfAllByWeddingDate(LocalDate weddingDate)
			throws EmployeeNotFoundException;
}
