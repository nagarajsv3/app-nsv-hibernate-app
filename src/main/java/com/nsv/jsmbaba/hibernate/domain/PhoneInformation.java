package com.nsv.jsmbaba.hibernate.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;


import javax.persistence.*;

@Getter
@Setter
//@ToString
@Entity
@Table(name="phoneinfo", schema = "javatraining")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PhoneInformation {

    @Id
    @GeneratedValue
    private int phoneId;

    private String home;
    private String work;
    private String cell;

    @OneToOne
    @JoinColumn(name="customerId")
    private Customer customer;

    @Override
    public String toString() {
        return "PhoneInformation{" +
                "phoneId=" + phoneId +
                ", home='" + home + '\'' +
                ", work='" + work + '\'' +
                ", cell='" + cell + '\'' +
                ", customer Name=" + customer.getName() +
                '}';
    }
}
