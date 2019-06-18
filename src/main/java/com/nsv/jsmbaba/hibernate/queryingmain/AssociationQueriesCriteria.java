package com.nsv.jsmbaba.hibernate.queryingmain;

import com.nsv.jsmbaba.hibernate.domain.Customer;
import com.nsv.jsmbaba.hibernate.domain.Order;
import com.nsv.jsmbaba.hibernate.domain.OrderStatus;
import com.nsv.jsmbaba.hibernate.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class AssociationQueriesCriteria {
    public static void main(String[] args) {

        //associationquery();
        //performCountUsingCriteriaAndProjection();
        performGroupUsingCriteriaAndProjection();

    }

    private static void associationquery() {
        SessionFactory sessionFactory = HibernateUtil.sessionFactory;
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Customer.class);
        criteria.add(Restrictions.like("name","S%"));
        criteria.createCriteria("orders").add(Restrictions.eq("orderStatus", OrderStatus.SHIPPED));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Customer> customers = criteria.list();
        System.out.println(customers);
        System.out.println("customer size="+customers.size());
        System.out.println("************************");
        for (Customer customer: customers) {
            System.out.println("------------------");
            System.out.println(customer.getName() + customer.getCustomerId());
            for (Order order: customer.getOrders()) {
                System.out.println(order.getItem()+" "+order.getOrderId()+" "+order.getOrderStatus());
            }
        }
        session.close();
        sessionFactory.close();
    }

    private static void performCountUsingCriteriaAndProjection() {
        SessionFactory sessionFactory = HibernateUtil.sessionFactory;
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Customer.class);
        criteria.add(Restrictions.eq("name","Sai"));
        criteria.add(Restrictions.eq("city","Newark"));
        criteria.setProjection(Projections.count("name"));
        List list = criteria.list();
        Long count = (Long)list.get(0);
        System.out.println("count="+count);
        session.close();
        sessionFactory.close();
    }

    private static void performGroupUsingCriteriaAndProjection() {
        SessionFactory sessionFactory = HibernateUtil.sessionFactory;
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Customer.class);
        criteria.setProjection(Projections.projectionList()
                .add(Projections.groupProperty("state"))
                .add(Projections.count("state"))

        );
        List list = criteria.list();
        for (Object obj:list) {
            Object[] o = (Object[]) obj;
            System.out.println(o[0]+"="+o[1]);
        }
        session.close();
        sessionFactory.close();
    }
}
