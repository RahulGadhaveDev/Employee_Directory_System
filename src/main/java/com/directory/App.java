package com.directory;

import java.util.Scanner;

import com.Repository.EmployeeRepo;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		EmployeeRepo employee = new EmployeeRepo();

		System.out.println("Enter a number ");
		System.out.println("1. Add a Employee");
		System.out.println("2. search a Employee");
		System.out.println("3.update Employee Salry");
		System.out.println("4. Delete Employee ");

		Scanner sc = new Scanner(System.in);

		int opration = sc.nextInt();
		switch (opration) {
		case 1:
			employee.addEmployee();
			break;
		case 2:
			employee.getEmployee();
			break;
		case 3:
			employee.updateSalary();
			break;
		case 4:
			employee.deleteEmployee();
			break;

		default:
			System.out.println("choose Right option");
			break;
		}
	}
}
