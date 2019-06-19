package com.nsv.jsmbaba.hibernate.caching;

import com.nsv.jsmbaba.hibernate.domain.Customer;
import com.nsv.jsmbaba.hibernate.domain.Order;
import com.nsv.jsmbaba.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class FirstLevelCachingMain {
    public static void main(String[] args) {
        readCustomerTwice();
    }

    private static void readCustomerTwice() {
        SessionFactory sessionFactory = HibernateUtil.sessionFactory;
        Session session = sessionFactory.openSession();
        Customer cust1 = (Customer) session.load(Customer.class, 162);
        System.out.println("Customer loaded from db"+cust1.toString());

        Customer cust2 = (Customer) session.load(Customer.class, 162);
        System.out.println("Customer loaded from db"+cust2.toString());

        Customer cust3= (Customer) session.load(Customer.class, 162);
        System.out.println("Customer loaded from db"+cust3.toString());

        Customer cust4= (Customer) session.load(Customer.class, 162);
        System.out.println("Customer loaded from db"+cust4.toString());

        Customer cust5= (Customer) session.load(Customer.class, 162);
        System.out.println("Customer loaded from db"+cust5.toString());


        session.close();
        sessionFactory.close();
    }
}
