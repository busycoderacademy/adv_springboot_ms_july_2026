package com.empapp.basics;

import com.util.factory.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class C_GetById {
    public static void main(String[] args) {
        //1. get the session factory
        SessionFactory factory= SessionFactoryUtil.getSessionFactory();

        //2. get the session from the session factory
        Session session=factory.openSession();

        //3. u need to start the tx
      //  Transaction tx=session.getTransaction();

     //  tx.begin();
        //Employee employee=session.get(Employee.class, 1);
        //session.evict(employee);//for remove the object from the cache
       // session.clear();

        Employee employee2=session.load(Employee.class, 1);
        session.close();
        System.out.println("-------------");
        System.out.println(employee2);

       // tx.commit();
        //close the session

        //close the session factory
        factory.close();






    }
}
