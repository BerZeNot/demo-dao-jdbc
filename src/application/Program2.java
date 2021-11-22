package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=== TEST 1: seller findById ===");
		Department department = departmentDao.findById(7);
		System.out.println(department);
		
		System.out.println("\n=== TEST 2: seller findAll ===");
		List<Department> list = departmentDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 3: seller insert ===");
		Department newDepartment = new Department(null, "Talentos Humanos");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		
		System.out.println("\n=== TEST 4: seller update ===");
		department = departmentDao.findById(7);
		department.setName("Recursos Humanos");
		departmentDao.update(department);
		System.out.println("Updated successful! New name: " + department.getName());
		
		System.out.println("\n=== TEST 5: seller delete ===");
		departmentDao.deleteById(6);
		System.out.println("Deleted successful!");
		sc.close();
	}
}
