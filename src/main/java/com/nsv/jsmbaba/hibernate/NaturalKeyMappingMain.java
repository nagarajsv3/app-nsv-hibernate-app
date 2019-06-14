package com.nsv.jsmbaba.hibernate;

import com.nsv.jsmbaba.hibernate.domain.Clerk;
import com.nsv.jsmbaba.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;

public class NaturalKeyMappingMain {

    public static void main(String[] args) {
        //createClerk();
        updateClerk();
    }

    private static void createClerk() {
        SessionFactory sessionFactory = HibernateUtil.sessionFactory;
        Session session = sessionFactory.openSession();

        Clerk clerk = new Clerk();
        clerk.setSsn("111-22-6666");
        clerk.setName("Marsh");
        clerk.setJoinedDate(new Date());
        clerk.setActive(true);

        Transaction transaction = session.beginTransaction();
        session.save(clerk);
        session.flush();
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    private static void updateClerk() {
        SessionFactory sessionFactory = HibernateUtil.sessionFactory;
        Session session = sessionFactory.openSession();

        Clerk clerk = (Clerk) session.load(Clerk.class, "111-22-6666");
        clerk.setTerminationDate(new Date());
        clerk.setActive(false);

        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(clerk);
        session.flush();
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
