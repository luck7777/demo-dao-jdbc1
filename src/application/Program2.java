package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Department department;
		
		System.out.println("=== TEST 1: department insert ===");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted New id = " + newDepartment.getId());
		
		System.out.println("\n=== TEST 2: department update ===");
		department = departmentDao.findById(2);
		department.setName("Shoes");
		departmentDao.update(department);
		System.out.println("Update Completed!");
		
		System.out.println("\n=== TEST 3: department findById ===");		
		department = departmentDao.findById(3);
		System.out.println(department);
		
				
		System.out.println("\n=== TEST 4: department findByAll ===");
		List<Department> list = new ArrayList<>();
		list = departmentDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
				
		System.out.println("\n=== TEST 5: delete =======");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");

		
		sc.close();
		
	}	
}
