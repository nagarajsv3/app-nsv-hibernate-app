package com.nsv.jsmbaba.hibernate.caching;

import com.nsv.jsmbaba.hibernate.domain.Customer;
import com.nsv.jsmbaba.hibernate.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class CriteriaQuerySecondLevelCaching {
    public static void main(String[] args) {
        readCustomersUsingCriteria();
    }

    private static void readCustomersUsingCriteria() {
        SessionFactory sessionFactory = HibernateUtil.sessionFactory;
        System.out.println("---First Session - BEGIN");
        Session firstSession = sessionFactory.openSession();
        Criteria criteria = firstSession.createCriteria(Customer.class);
        criteria.add(Restrictions.eq("customerId",100));
        criteria.setCacheable(true);

        Customer customer1S1 = (Customer) criteria.uniqueResult();

        Customer customer2S1 = (Customer) criteria.uniqueResult();
        firstSession.close();
        System.out.println("---First Session - END");
        System.out.println("---Second Session - BEGIN");
        Session secondSession = sessionFactory.openSession();
        Criteria criteria2 = secondSession.createCriteria(Customer.class);
        criteria2.setCacheable(true);
        criteria2.add(Restrictions.eq("customerId",100));

        Customer customer1S2 = (Customer) criteria2.uniqueResult();

        Customer customer2S2 = (Customer) criteria2.uniqueResult();
        secondSession.close();
        System.out.println("---Second Session - END");
        sessionFactory.close();

    }


}
