package com.nsv.jsmbaba.hibernate.caching;

import com.nsv.jsmbaba.hibernate.domain.Customer;
import com.nsv.jsmbaba.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SecondLevelCachingMain {


    public static void main(String[] args) {
        readCustomer();
    }
    private static void readCustomer() {
        SessionFactory sessionFactory = HibernateUtil.sessionFactory;
        Session firstSession = sessionFactory.openSession();
        Customer customer1Session1 = (Customer) firstSession.load(Customer.class, 162);
        System.out.println("Customer loaded from db"+customer1Session1.toString());

        Customer customer2Session1 = (Customer) firstSession.load(Customer.class, 162);
        System.out.println("Customer loaded from db"+customer2Session1.toString());
        firstSession.close();

        System.out.println("---------------------------------");

        Session secondSession = sessionFactory.openSession();
        Customer customer1Session2 = (Customer) secondSession.load(Customer.class, 162);
        System.out.println("Customer loaded from db"+customer1Session2.toString());

        Customer customer2Session2 = (Customer) secondSession.load(Customer.class, 162);
        System.out.println("Customer loaded from db"+customer2Session2.toString());

        secondSession.close();

        sessionFactory.close();
    }
}

