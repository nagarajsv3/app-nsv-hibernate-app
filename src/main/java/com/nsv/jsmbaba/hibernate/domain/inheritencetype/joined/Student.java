package com.nsv.jsmbaba.hibernate.domain.inheritencetype.joined;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name="student")
@PrimaryKeyJoinColumn(name="student_id",  referencedColumnName = "person_id")
public class Student extends Person {
    private String instructor;
    private String standard;
}
