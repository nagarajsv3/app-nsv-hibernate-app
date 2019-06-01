package com.nsv.jsmbaba.hibernate;

import com.nsv.jsmbaba.hibernate.domain.Customer;
import com.nsv.jsmbaba.hibernate.domain.Order;
import com.nsv.jsmbaba.hibernate.domain.OrderStatus;
import com.nsv.jsmbaba.hibernate.domain.PhoneInformation;
import com.nsv.jsmbaba.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateOneToManyMappingMain {
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

        //One To One
        PhoneInformation nagasphone = new PhoneInformation();
        nagasphone.setCell("111111111");
        nagasphone.setHome("222222222");
        nagasphone.setWork("333333333");

        naga.setPhoneInformation(nagasphone);
        nagasphone.setCustomer(naga);


        //One To Many
        Order o1 = new Order();
        o1.setItem("Laptop");
        o1.setOrderStatus(OrderStatus.PLACED);
        o1.setCustomer(naga);

        Order o2 = new Order();
        o2.setItem("iPhone");
        o2.setOrderStatus(OrderStatus.SHIPPED);
        o2.setCustomer(naga);

        Order o3 = new Order();
        o3.setItem("TV");
        o3.setOrderStatus(OrderStatus.PLACED);
        o3.setCustomer(naga);

        naga.getOrders().add(o1);
        naga.getOrders().add(o2);
        naga.getOrders().add(o3);

        session.save(naga);
        session.close();
        sessionFactory.close();

    }
}
