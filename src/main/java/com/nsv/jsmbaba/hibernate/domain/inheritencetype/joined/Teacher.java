package com.nsv.jsmbaba.hibernate.domain.inheritencetype.joined;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name="teacher")
@PrimaryKeyJoinColumn(name="teacher_id",  referencedColumnName = "person_id")
public class Teacher extends Person{
    @Column(name="main_subject")
    private String mainSubject;
    private Long salary;
    private String type;
}
