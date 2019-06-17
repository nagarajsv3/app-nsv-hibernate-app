package com.nsv.jsmbaba.hibernate;

import com.nsv.jsmbaba.hibernate.domain.inheritencetype.joined.Person;
import com.nsv.jsmbaba.hibernate.domain.inheritencetype.joined.Student;
import com.nsv.jsmbaba.hibernate.domain.inheritencetype.joined.Teacher;
import com.nsv.jsmbaba.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateInheritanceTypeJoinedMain {
    public static void main(String[] args) {
/*
        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Carter");
        student.setStandard("Masters");
        student.setInstructor("Nagaraja");
*/

/*
        Teacher teacher = new Teacher();
        teacher.setFirstName("Nagaraja");
        teacher.setLastName("Varnekar");
        teacher.setMainSubject("Java Programming");
        teacher.setSalary(1000L);
        teacher.setType("FullTime");
*/

        Person person = new Person();
        person.setFirstName("Anna");
        person.setLastName("Korgis");

        SessionFactory sessionFactory = HibernateUtil.sessionFactory;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(person);
        session.flush();
        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}
