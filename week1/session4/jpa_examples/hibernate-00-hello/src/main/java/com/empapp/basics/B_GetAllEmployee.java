package com.empapp.basics;

import com.util.factory.SessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

public class B_GetAllEmployee {
    public static void main(String[] args) {
        //SQL vs ORM HQL ( oo version of sql)==> portablity
        SessionFactory factory= SessionFactoryUtil.getSessionFactory();
        Session session=factory.openSession();



        //hey hib i want all the records : orm, HQL OO way of writing sql vs SQL
        //select * from Employee

//        List<Employee> employees=session.createQuery("select e from Employee  e", Employee.class)
//                            .getResultList();
//        employees.forEach(e-> System.out.println(e));


        //Sec ex
//        List<String> employees2=session
//                .createQuery("select e.name from Employee e", String.class).getResultList();
//
//        employees2.forEach(e-> System.out.println(e));

//        List<String> employees=session.createQuery("select e.name from Employee e", String.class).getResultList();
//        employees.forEach(e-> System.out.println(e));

       List<EmployeeSelectedDataDto> employees=session
               .createQuery
                       ("select new com.empapp.basics.EmployeeSelectedDataDto(e.name, e.salary) from Employee e",
                               EmployeeSelectedDataDto.class).getResultList();
//
        employees.forEach(e-> System.out.println(e));


//        List<Object[]> employeesList=session
//                .createQuery("select e.name,e.salary from Employee e", Object[].class).getResultList();
//
//    //employeesList printing
//        employeesList.forEach(e-> System.out.println(e));
//

    }
}
