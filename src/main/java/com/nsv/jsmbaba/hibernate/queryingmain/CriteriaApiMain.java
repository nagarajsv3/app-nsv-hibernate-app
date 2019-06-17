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
        criteria.add(Restrictions.eq("state","DE"));
        criteria.add(Restrictions.eq("city","Newark"));
        List<Customer> list = criteria.list();

        System.out.println("size"+list.size());
        System.out.println("==========================================");
        list.forEach(customer -> {
            System.out.println(customer.getName()+" "+customer.getState()+" "+customer.getCity());
        });
        session.close();
        sessionFactory.close();

    }
}
