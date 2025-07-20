package com.Repository;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Entity.Adress;
import com.Entity.EmployeeDetail;
import com.Utility.EmployeeUtility;

public class EmployeeRepo {

	Scanner sc = new Scanner(System.in);

	public void addEmployee() {

		EmployeeDetail emp = new EmployeeDetail();

		System.out.println("Enter Employee name");
		String empName = sc.next();
		emp.setEmployeeName(empName);

		System.out.println("Enter Employee Designation");
		String empDesignation = sc.next();
		emp.setEmployeeDesignation(empDesignation);

		System.out.println("Enter employee Salary ");
		long empSalary = sc.nextLong();
		emp.setEmployeeSalary(empSalary);

		System.out.println("Enter employee Department");
		String empDepartment = sc.next();
		emp.setEmployeeDepartment(empDepartment);

		Adress adress = new Adress();

		System.out.println("Enter Employee city ");
		String city = sc.next();
		adress.setCity(city);

		System.out.println("Enter employee dist");
		String dist = sc.next();
		adress.setDist(dist);

		System.out.println("Enter employee pin Code ");
		int pinCode = sc.nextInt();
		adress.setPinCode(pinCode);

		emp.setAdress(adress);

		SessionFactory factory = EmployeeUtility.getfactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.persist(emp);

		transaction.commit();
		session.close();
	}

	public void getEmployee() {

		SessionFactory factory = EmployeeUtility.getfactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("Enter Employee Name");
		String empName = sc.next();

		List<EmployeeDetail> employee = session
				.createQuery("select e from EmployeeDetail e where e.employeeName = empName", EmployeeDetail.class)
				.getResultList();
		System.out.println(employee.toString());

		transaction.commit();
		session.close();
	}

	public void updateSalary() {
		SessionFactory factory = EmployeeUtility.getfactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("Enter employee Id");
		int empId = sc.nextInt();
		EmployeeDetail emp = session.find(EmployeeDetail.class, empId);

		System.out.println("Enter Employee updated Salary");
		long empSalary = sc.nextLong();
		emp.setEmployeeSalary(empSalary);

		transaction.commit();
		session.close();
	}

	public void updateAdress() {
		SessionFactory factory = EmployeeUtility.getfactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("Enter Employee Id");
		int id = sc.nextInt();
		EmployeeDetail employee = session.find(EmployeeDetail.class, id);

		System.out.println("Enter employee city");
		String city = sc.next();
		employee.getAdress().setCity(city);

		System.out.println("Enter employee dist ");
		String dist = sc.next();
		employee.getAdress().setDist(dist);

		System.out.println("Enter employee Pin Code ");
		int pinCode = sc.nextInt();
		employee.getAdress().setPinCode(pinCode);

		transaction.commit();
		session.close();
	}

	// using unidirection mapping delete Employee
	public void deleteEmployee() {
		SessionFactory factory = EmployeeUtility.getfactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("Enter Employee Id to Delete ");
		int empId = sc.nextInt();
		EmployeeDetail emp = session.find(EmployeeDetail.class, empId);

		session.remove(emp);

		transaction.commit();
		session.close();
	}

}
