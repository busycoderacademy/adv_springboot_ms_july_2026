package com.empapp.basics;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transaction;

public class A_AddEmployee {
    public static void main(String[] args) {


        EntityManagerFactory emf= Persistence.createEntityManagerFactory("busycoder");
        EntityManager em=emf.createEntityManager();

        EntityTransaction tx=em.getTransaction();
        try{
            tx.begin();
            Employee employee1=new Employee("sumit",6700,"IT");
            System.out.println("----------------------");
            Employee employee2=new Employee("kapil",9700,"Training");
            System.out.println("----------------------");
            Employee employee3=new Employee("Seema",9710,"Fin");

            System.out.println("599999999999999999999");
            em.persist(employee1);
            em.persist(employee2);
            System.out.println("555555555555555555555");
            tx.commit();
        }catch (Exception e){
            System.out.println(e);
            tx.rollback();
        }
        em.close();
        emf.close();




        //close the session
        //close the session factory


    }
}
