package com.nsv.jsmbaba.hibernate.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customer", schema="javatraining")
public class Customer implements Serializable{

    @Id
    @GeneratedValue
    private int customerId;

    @Column(name="name",nullable = false)
    private String name;

    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    @Transient
    private String fullName;

    //private PhoneInformation phoneInformation;
    //private List<Order> orders = new ArrayList<>();

}
