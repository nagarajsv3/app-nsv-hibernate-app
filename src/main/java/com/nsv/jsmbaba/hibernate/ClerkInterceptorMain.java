package com.nsv.jsmbaba.hibernate;

import com.nsv.jsmbaba.hibernate.domain.Clerk;
import com.nsv.jsmbaba.hibernate.interceptor.ClerkInterceptor;
import com.nsv.jsmbaba.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ClerkInterceptorMain {
    public static void main(String[] args) {
        deleteClerk();
    }

    private static void deleteClerk() {
        SessionFactory sessionFactory = HibernateUtil.sessionFactory;
        Session session = sessionFactory
                .withOptions().interceptor(new ClerkInterceptor())
                .openSession();
        Clerk clerk = (Clerk)session.load(Clerk.class, "111-22-6666");
        Transaction transaction = session.beginTransaction();
        session.delete(clerk);
        session.flush();
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
