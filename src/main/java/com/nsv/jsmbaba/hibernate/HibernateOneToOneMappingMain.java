package com.nsv.jsmbaba.hibernate;

import com.nsv.jsmbaba.hibernate.domain.Customer;
import com.nsv.jsmbaba.hibernate.domain.PhoneInformation;
import com.nsv.jsmbaba.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateOneToOneMappingMain {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.sessionFactory;
        Session session = sessionFactory.openSession();

        Customer naga = new Customer();
        naga.setName("Naga");
        naga.setStreet("3 Capano Drive");
        naga.setCity("Newark");
        naga.setState("DE");
        naga.setCountry("US");
        naga.setZipCode("19702");

        PhoneInformation nagasphone = new PhoneInformation();
        nagasphone.setCell("111111111");
        nagasphone.setHome("222222222");
        nagasphone.setWork("333333333");

        naga.setPhoneInformation(nagasphone);
        nagasphone.setCustomer(naga);

        session.save(naga);
        session.close();
        sessionFactory.close();

    }
}
