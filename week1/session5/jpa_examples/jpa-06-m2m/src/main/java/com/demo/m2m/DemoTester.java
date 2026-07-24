package com.demo.m2m;

import java.util.*;

import com.demo.factory.EmFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;


public class DemoTester {

	public static void main(String[] args) {

		Employee employee1 = new Employee("raja");
		Employee employee2 = new Employee("amit");

		Employee employee3 = new Employee("sumit");
		Employee employee4 = new Employee("ekta");

		Employee employee7 = new Employee("rajiv");
		Employee employee8 = new Employee("nitin");

		Project project1 = new Project("proj A");
		Project project2 = new Project("proj B");

		Project project3 = new Project("proj C");
		Project project4 = new Project("proj D");

		project1.getEmployees().add(employee1);
		project1.getEmployees().add(employee3);

		project2.getEmployees().add(employee1);
		project2.getEmployees().add(employee3);
		project2.getEmployees().add(employee4);

		project3.getEmployees().add(employee2);
		project3.getEmployees().add(employee3);
		project3.getEmployees().add(employee4);

		project4.getEmployees().add(employee2);
		project4.getEmployees().add(employee4);

		employee1.getProjects().add(project1);
		employee1.getProjects().add(project2);

		employee2.getProjects().add(project3);
		employee2.getProjects().add(project4);

		employee3.getProjects().add(project1);
		employee3.getProjects().add(project2);
		employee3.getProjects().add(project3);

		employee4.getProjects().add(project4);
		employee4.getProjects().add(project2);
		employee4.getProjects().add(project3);

		EntityManagerFactory emf  = EmFactory.getEMFactory();

		EntityManager em  = emf.createEntityManager();

		em.getTransaction().begin();
//
//		List<Employee> employees=em
//				.createQuery("select e from Employee e",Employee.class).getResultList();
//
//		for (Employee e: employees){
//			System.out.println(e.getEmpName());
//			System.out.println("No of project : "+ e.getProjects().size());
//		}
		em.persist(project1);
		em.persist(project2);
		em.persist(project3);
		em.persist(project4);

		em.persist(employee1);
		em.persist(employee2);
		em.persist(employee3);
		em.persist(employee4);

		em.getTransaction().commit();

		em.close();
		emf.close();

	}

}
