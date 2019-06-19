package com.nsv.jsmbaba.hibernate.queryingmain;

import com.nsv.jsmbaba.hibernate.domain.Customer;
import com.nsv.jsmbaba.hibernate.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class HqlMain {
    public static void main(String[] args) {
        //readCustomersUsingHql();
        //readCustomersUsingNativeSql();
        readCustomersLivingInNewarkUsingHql();
    }

    private static void readCustomersUsingHql() {
        SessionFactory sessionFactory = HibernateUtil.sessionFactory;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Customer");
        List<Customer> customers = query.list();
        customers.forEach(customer -> {
            System.out.println(customer.getCustomerId() + " " + customer.getName());
        });
        session.close();
        sessionFactory.close();
    }

    private static void readCustomersLivingInNewarkUsingHql() {
        SessionFactory sessionFactory = HibernateUtil.sessionFactory;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Customer where city = :city");
        query.setString("city","Newark");
        List<Customer> customers = query.list();
        customers.forEach(customer -> {
            System.out.println(customer.getCustomerId() + " " + customer.getName());
        });
        session.close();
        sessionFactory.close();
    }

    private static void readCustomersUsingNativeSql() {
        SessionFactory sessionFactory = HibernateUtil.sessionFactory;
        Session session = sessionFactory.openSession();
        Query query = session.createSQLQuery("select * from Customer").addEntity(Customer.class);
        List<Customer> customers = query.list();
        customers.forEach(customer -> {
            System.out.println(customer.getCustomerId() + " " + customer.getName());
        });
        session.close();
        sessionFactory.close();
    }


}
