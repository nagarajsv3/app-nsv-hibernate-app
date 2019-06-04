package com.nsv.jsmbaba.hibernate.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
//@ToString

@Entity
@Table(name="ordersplaced", schema = "javatraining")
public class Order {
    @Id
    @GeneratedValue
    private int orderId;

    private String item;
    @Column(name="order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @ManyToOne
    @JoinColumn(name="customerId")
    private Customer customer;

    private int idx;

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", item='" + item + '\'' +
                ", orderStatus=" + orderStatus +
                ", customerName=" + customer.getName() +
                ", idx=" + idx +
                '}';
    }
}
