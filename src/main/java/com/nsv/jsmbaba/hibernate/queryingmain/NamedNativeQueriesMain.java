package com.nsv.jsmbaba.hibernate.queryingmain;

import com.nsv.jsmbaba.hibernate.domain.Clerk;
import com.nsv.jsmbaba.hibernate.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class NamedNativeQueriesMain {
    public static void main(String[] args) {
        //findActiveClerksUsingNamedQuery();
        //findTerminatedClerksUsingNamedQuery();
        //findActiveClerksUsingNamedNativeQuery();
        findTerminatedClerksUsingNamedNativeQuery();
    }

    private static void findTerminatedClerksUsingNamedNativeQuery() {
        SessionFactory sessionFactory = HibernateUtil.sessionFactory;
        Session session = sessionFactory.openSession();
        Query findActiveClerksNativeNamedQuery = session.getNamedQuery("findTerminatedClerkNamedNativeQuery");
        List<Clerk> list = findActiveClerksNativeNamedQuery.list();
        list.forEach(clerk -> {
            System.out.println(clerk);
        });

        session.close();
        sessionFactory.close();
    }

    private static void findActiveClerksUsingNamedNativeQuery() {
        SessionFactory sessionFactory = HibernateUtil.sessionFactory;
        Session session = sessionFactory.openSession();
        Query findActiveClerksNativeNamedQuery = session.getNamedQuery("findActiveClerksNativeNamedQuery");
        List<Clerk> list = findActiveClerksNativeNamedQuery.list();
        list.forEach(clerk -> {
            System.out.println(clerk);
        });
        session.close();
        sessionFactory.close();
    }

    private static void findTerminatedClerksUsingNamedQuery() {
        SessionFactory sessionFactory = HibernateUtil.sessionFactory;
        Session session = sessionFactory.openSession();
        Query terminatedClerks = session.getNamedQuery("findterminatedClerks");
        List<Clerk> clerks = terminatedClerks.list();
        clerks.forEach(clerk -> {
            System.out.println(clerk.toString());
        });
        session.close();
        sessionFactory.close();
    }

    private static void findActiveClerksUsingNamedQuery() {
        SessionFactory sessionFactory = HibernateUtil.sessionFactory;
        Session session = sessionFactory.openSession();
        Query namedQuery = session.getNamedQuery("findActiveClerks");
        List<Clerk> clerks = namedQuery.list();
        clerks.forEach(clerk->{
            System.out.println(clerk.toString());
        });
        session.close();
        sessionFactory.close();
    }
}
