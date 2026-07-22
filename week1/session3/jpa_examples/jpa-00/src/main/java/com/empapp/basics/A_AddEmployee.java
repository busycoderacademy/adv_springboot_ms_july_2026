package com.empapp.basics;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transaction;

public class A_AddEmployee {
    public static void main(String[] args) {
        //SessionFactory --- EntityMangerFactor
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("EMP_JPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        try{
            entityTransaction.begin();
            Employee employee1=new Employee("gunika",6700,"IT");
            Employee employee2=new Employee("keshav",9700,"Training");
            Employee employee3=new Employee("ekta",9710,"Fin");
            entityManager.persist(employee1);
            entityManager.persist(employee2);
            entityManager.persist(employee3);

            entityTransaction.commit();
        }catch(Exception e){
            entityTransaction.rollback();
        }


        //session---------------- entitymanager
        //save  persist
        //update    merge
        //delete  remove


//
//        em.persist(employee1);
//        em.persist(employee2);

    }
}
