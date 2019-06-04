package com.nsv.jsmbaba.hibernate;

import com.nsv.jsmbaba.hibernate.domain.Customer;
import com.nsv.jsmbaba.hibernate.domain.Order;
import com.nsv.jsmbaba.hibernate.domain.OrderStatus;
import com.nsv.jsmbaba.hibernate.domain.PhoneInformation;
import com.nsv.jsmbaba.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class HibernateOneToManyMappingMain {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.sessionFactory;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Customer naga = new Customer();
        naga.setName("Sai");
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


        List<Order> orders = new ArrayList<>();

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

        System.out.println("Orders Size before adding orders"+naga.getOrders().size());
        orders.add(o1);
        orders.add(o2);
        orders.add(o3);

        naga.setOrders(orders);

        System.out.println("Orders Size after adding orders"+naga.getOrders().size());

        session.save(naga);
        session.flush();
        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}
