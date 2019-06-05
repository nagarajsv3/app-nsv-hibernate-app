package com.nsv.jsmbaba.hibernate;

import com.nsv.jsmbaba.hibernate.domain.*;
import com.nsv.jsmbaba.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class HibernateManyToManyMappingMain {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.sessionFactory;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Reviewer reviewer = new Reviewer();
        reviewer.setReviewerName("Naga");

        Task programming = new Task();
        programming.setTaskName("programming");

        Task analysing  = new Task();
        analysing.setTaskName("analysing");

        List<Task> reviewertasks = new ArrayList<>();
        reviewertasks.add(programming);
        reviewertasks.add(analysing);

        reviewer.setTasks(reviewertasks);

        session.save(reviewer);
        session.flush();
        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}
