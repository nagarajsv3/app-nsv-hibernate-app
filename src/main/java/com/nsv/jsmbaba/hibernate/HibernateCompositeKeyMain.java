package com.nsv.jsmbaba.hibernate;

import com.nsv.jsmbaba.hibernate.domain.Author;
import com.nsv.jsmbaba.hibernate.domain.CompositeKeyAuthor;
import com.nsv.jsmbaba.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateCompositeKeyMain {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.sessionFactory;
        Session session = sessionFactory.openSession();

        CompositeKeyAuthor ck1 = new CompositeKeyAuthor();
        ck1.setFirstName("Nagaraja");
        ck1.setLastName("Varnekar");
        ck1.setTitle("How to program in Java");

        Author naga = new Author();
        naga.setCompositeKeyAuthor(ck1);
        naga.setMiddleName("Srinivasa");
        naga.setIsbn("1234");
        naga.setVersionId(1);


/*
        Author naga2 = new Author();
        naga2.setCompositeKeyAuthor(ck1);
        naga2.setMiddleName("Srinivasa");
        naga2.setIsbn("1234");
        naga2.setVersionId(1);
*/

        Transaction transaction = session.beginTransaction();
        session.save(naga);
        session.flush();
        transaction.commit();

/*
        Transaction transaction2 = session.beginTransaction();
        session.save(naga2);
        session.flush();
        transaction2.commit();
*/


        session.close();
        sessionFactory.close();


    }
}
