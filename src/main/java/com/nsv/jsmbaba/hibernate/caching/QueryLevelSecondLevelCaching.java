package com.nsv.jsmbaba.hibernate.caching;

import com.nsv.jsmbaba.hibernate.domain.Customer;
import com.nsv.jsmbaba.hibernate.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class QueryLevelSecondLevelCaching {
    public static void main(String[] args) {
        readCustomersLivingInNewarkUsingHql();
    }

    private static void readCustomersLivingInNewarkUsingHql() {
        SessionFactory sessionFactory = HibernateUtil.sessionFactory;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Customer where city = :city");
        query.setString("city","MiddleTown");
        query.setCacheable(true);
        List<Customer> customers1 = query.list();
        List<Customer> customers2 = query.list();
        List<Customer> customers3= query.list();
        //System.out.println("Customer Size="+customers1.size());
        //System.out.println("Customer Size="+customers2.size());
        session.close();

        Session session2 = sessionFactory.openSession();
        Query query2 = session2.createQuery("from Customer where city = :city");
        query2.setString("city","MiddleTown");
        query2.setCacheable(true);
        List<Customer> customers4 = query2.list();
        List<Customer> customers5 = query2.list();
        List<Customer> customers6= query2.list();
        //System.out.println("Customer Size="+customers1.size());
        //System.out.println("Customer Size="+customers2.size());
        session2.close();

        sessionFactory.close();
    }

}
