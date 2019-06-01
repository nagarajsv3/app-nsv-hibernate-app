package com.nsv.jsmbaba.hibernate;

import com.nsv.jsmbaba.hibernate.domain.Customer;
import com.nsv.jsmbaba.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;

public class HibernateAppMain {

    public static void main(String[] args) {
        System.out.println("-----Create Customer-BEGIN-----------------");
        //createCustomer();
        System.out.println("-----Create Customer-END-----------------");
        System.out.println("-----Load Customer-BEGIN-----------------");
        readCustomer();
        System.out.println("-----Load Customer-END-----------------");
        System.out.println("-----Update Customer-BEGIN-----------------");
        //updateCustomer();
        System.out.println("-----Update Customer-END-----------------");
    }

    private static void updateCustomer() {
        SessionFactory sessionFactory = HibernateUtil.sessionFactory;
        Session session = sessionFactory.openSession();

        System.out.println("Load Customer with id="+149);
        Customer nagaraj = (Customer)session.load(Customer.class, 149);
        nagaraj.setName("Nagaraja");
        System.out.println("Customer to be updated="+nagaraj.toString());

        Transaction transaction = session.beginTransaction();
        session.update(nagaraj);
        transaction.commit();

        session.close();
        sessionFactory.close();

    }

    private static void createCustomer() {
        SessionFactory sessionFactory = HibernateUtil.sessionFactory;
        Session session = sessionFactory.openSession();
        Customer customer = new Customer();
        customer.setName("SaiBaba");
        customer.setStreet("3 Capano Drive");
        customer.setCity("Newark");
        customer.setState("DE");
        customer.setCountry("US");
        customer.setZipCode("19702");
        int id = (int) session.save(customer);
        System.out.println("Primary Key of the customer created="+id);
        session.close();
        sessionFactory.close();
    }

    private static void readCustomer() {
        SessionFactory sessionFactory = HibernateUtil.sessionFactory;
        Session session = sessionFactory.openSession();
        Customer cust = (Customer) session.load(Customer.class, 152);
        System.out.println("Customer loaded from db"+cust.toString());
        session.close();
        sessionFactory.close();
    }
}
