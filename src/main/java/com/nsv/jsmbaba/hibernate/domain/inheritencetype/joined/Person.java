package com.nsv.jsmbaba.hibernate.domain.inheritencetype.joined;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name="person")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    @GeneratedValue
    @Column(name="person_id")
    private Long id;
    private String firstName;
    private String lastName;
}
