package com.nsv.jsmbaba.hibernate.domain.inheritencetype.singletable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@ToString
@Entity
@Table(name="cd")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="cd_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Cd")
public class Cd {
    @Id
    @GeneratedValue
    @Column(name="cd_id")
    private Long id;
    private String title;
    private String artist;
    private Date purchase_date;
    private String cost;
}
