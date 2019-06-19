package com.nsv.jsmbaba.hibernate;

import com.nsv.jsmbaba.hibernate.domain.Author;
import com.nsv.jsmbaba.hibernate.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class OptimisticLockingMain {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.sessionFactory;
        Session session = sessionFactory.openSession();
        //Read Customer
        Criteria criteria = session.createCriteria(Author.class);
        criteria.add(Restrictions.eq("middleName","Henry2"));
        Author author = (Author) criteria.uniqueResult();

        //Update Customer
        author.setMiddleName("Stockes");

        //Commit the Changes
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(author);
        session.flush();
        transaction.commit();

        session.close();
        sessionFactory.close();
    }
}
