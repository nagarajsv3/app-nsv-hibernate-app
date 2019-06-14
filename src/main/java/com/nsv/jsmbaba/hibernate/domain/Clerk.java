package com.nsv.jsmbaba.hibernate.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name="clerk", schema = "javatraining")
public class Clerk {

    @Id
    private String ssn;
    private String name;
    private Date joinedDate;
    private Date terminationDate;

    @Type(type="org.hibernate.type.NumericBooleanType")
    private boolean active;

}
