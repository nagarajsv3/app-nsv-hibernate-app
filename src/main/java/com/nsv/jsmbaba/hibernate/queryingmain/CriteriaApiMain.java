package com.nsv.jsmbaba.hibernate.queryingmain;

import com.nsv.jsmbaba.hibernate.domain.Customer;
import com.nsv.jsmbaba.hibernate.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CriteriaApiMain {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.sessionFactory;
        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(Customer.class);

/*        System.out.println("Query : Criteria: used to fetch list of customers");
        criteria.add(Restrictions.eq("state","DE"));
        criteria.add(Restrictions.eq("city","Newark"));
        List<Customer> list = criteria.list();

        System.out.println("size"+list.size());
        System.out.println("==========================================");
        list.forEach(customer -> {
            System.out.println(customer.getName()+" "+customer.getState()+" "+customer.getCity());
        });*/

/*
        System.out.println("==========================================");
        System.out.println("Query : Criteria: used to fetch unique customer");
        criteria.add(Restrictions.eq("name","Aarav"));
        Customer customer = (Customer) criteria.uniqueResult();
        System.out.println(customer);

*/

        System.out.println("==========================================");
        System.out.println("Query : Criteria: using like operation");
        criteria.add(Restrictions.like("name","S%"));
        List<Customer> list = criteria.list();
        System.out.println("size"+list.size());
        list.forEach(customer -> {
            System.out.println(customer.getName());
        });
        session.close();
        sessionFactory.close();

    }
}
