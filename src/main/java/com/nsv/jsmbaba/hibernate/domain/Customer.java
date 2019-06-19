package com.nsv.jsmbaba.hibernate.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
//@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer", schema = "javatraining")
@NamedNativeQueries(value = {
        @NamedNativeQuery(name = "callcustomerstoredproc",
                query = "call fetchCustomers1(:customerId)",
                resultClass = Customer.class)
})
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Customer implements Serializable {

    @Id
    @GeneratedValue
    private int customerId;

    @Column(name = "name", nullable = false)
    private String name;

    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    @Transient
    private String fullName;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private PhoneInformation phoneInformation;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)//, fetch = FetchType.LAZY)
    //@OrderColumn(name="idx")
    @LazyCollection(value = LazyCollectionOption.TRUE)
    private List<Order> orders = new ArrayList<>();


    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", fullName='" + fullName + '\'' + "\n" +
//                ", phoneInformation=" + phoneInformation + "\n" +
//                ", orders=" + orders + "\n" +
                '}';
    }
}
