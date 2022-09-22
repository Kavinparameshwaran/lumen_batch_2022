package com.training.model;

import java.time.LocalDate;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.example.demo.sevices.EmployeeService;
import com.training.exceptions.EmployeeNotFoundException;

public class App {
	private static final Logger logger = LogManager.getRootLogger();
	public static void takeInputFromUser(Scanner input,EmployeeService service) throws EmployeeNotFoundException {
		logger.info("Enter number between 1 to 7");
		logger.info("1->Add Employee");
		logger.info("2->Find Employees By First Name");
		logger.info("3->Find First Name and Phone Number of all Employees");
		logger.info("4->Update Email and PhoneNumber of a Particular Employee");
		logger.info("5->Delete Employee by First Name");
		logger.info("6->Find First Name and Email of all Employees by Birthday");
		logger.info("7->Find First Name and Phone Number of all Employees by Wedding Date");
		logger.info("Enter the number");
		int choice = Integer.parseInt(input.nextLine());
		if (choice == 1) {
			logger.info("-------------Enter required details to add Employee---------------------");
			logger.info("First Name:");
			String firstName = input.nextLine();
			logger.info("Last Name:");
			String lastName = input.nextLine();
			logger.info("Address:");
			String address = input.nextLine();
			logger.info("Email:");
			String email = input.nextLine();
			logger.info("Phone Number:");
			long phoneNumber = Long.parseLong(input.nextLine());
			logger.info("Date Of Birth in the format (YYYY-MM-DD):");
			LocalDate dateOfBirth = LocalDate.parse(input.nextLine());
			LocalDate weddingDate=null;
			logger.info("Are you married? y/n");
			String weddingChoice=input.nextLine();
			if (weddingChoice.equalsIgnoreCase("y")) {
				logger.info("Wedding Date in the format (YYYY-MM-DD):");
				weddingDate = LocalDate.parse(input.nextLine());
			}
			service.save(new Employee(firstName, lastName, address, email, phoneNumber, dateOfBirth, weddingDate));
		} else if (choice == 2) {
			logger.info("2->Find Employees By First Name");
			logger.info("First Name:");
			String firstName = input.nextLine();
			service.findByFirstName(firstName);
		} else if (choice == 3) {
			logger.info("3->Find First Name and Phone Number of all Employees");
			service.findFirstNameAndPhoneNumberOfAll();
		} else if (choice == 4) {
			logger.info("4->Update Email and PhoneNumber of a Particular Employee");
			logger.info("Updated Email:");
			String updatedEmail = input.nextLine();
			logger.info("Phone Number:");
			long phoneNumber = Long.parseLong(input.nextLine());
			logger.info("Old Email:");
			String email = input.nextLine();
			service.updateByEmailAndPhoneNumberOfAnEmployee(updatedEmail, phoneNumber, email);
		} else if (choice == 5) {
			logger.info("5->Delete Employee by First Name");
			logger.info("First Name:");
			String firstName = input.nextLine();
			logger.info("Email:");
			String email = input.nextLine();
			service.deleteByFirstName(firstName, email);
		} else if (choice == 6) {
			logger.info("6->Find First Name and Email of all Employees by Birthday");
			logger.info("Date Of Birth:");
			LocalDate dateOfBirth = LocalDate.parse(input.nextLine());
			service.findFirstNameAndEmailOfAllByBirthday(dateOfBirth);
		} else if (choice == 7) {
			logger.info("7->Find First Name and Phone Number of all Employees by Wedding Date");
			logger.info("Wedding Date:");
			LocalDate weddingDate = LocalDate.parse(input.nextLine());
			service.findFirstNameAndPhoneNumberOfAllByWeddingDate(weddingDate);
		}
	}

	public static void main(String[] args) throws EmployeeNotFoundException {
		System.out.println("Kavin is a good boy, and sabareesh is a bad boy , done by mohan");
		EmployeeService service = new EmployeeService();
		while (true) {
			Scanner input = new Scanner(System.in);
			takeInputFromUser(input,service);
			logger.info("Do you want to continue? y/n");
			String willingToContinue=input.nextLine();
			if (!willingToContinue.equalsIgnoreCase("y")) {
				input.close();
				logger.info("Successfully Exited from the Menu");
				break;
			}
		}

	}

}
