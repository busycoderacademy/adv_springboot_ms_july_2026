package com.empapp.basics;


import jakarta.persistence.*;

import java.util.List;

public class B_GetAll {
    public static void main(String[] args) {

        EntityManagerFactory emf= Persistence.createEntityManagerFactory("busycoder");
        EntityManager em=emf.createEntityManager();

        //print all employee
        String jpql = "select e from Employee e";

        List<Employee> employees = em.createQuery(jpql, Employee.class).getResultList();

        em.close();
        emf.close();




        //close the session
        //close the session factory


    }
}
