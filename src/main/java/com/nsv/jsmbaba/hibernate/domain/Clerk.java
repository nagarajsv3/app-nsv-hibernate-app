package com.nsv.jsmbaba.hibernate.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "clerk", schema = "javatraining")
@NamedQueries(value = {
        @NamedQuery(name = "findActiveClerks",
                query = " from Clerk where active=true"),
        @NamedQuery(name = "findterminatedClerks",
                query = " from Clerk where active=false"),
})
@NamedNativeQueries(value = {
        @NamedNativeQuery(name = "findActiveClerksNativeNamedQuery",
                query = "select * from clerk where active='1';",
                resultClass = Clerk.class),
        @NamedNativeQuery(name = "findTerminatedClerkNamedNativeQuery",
                query = "select * from clerk where active='0';",
                resultClass = Clerk.class)
})
public class Clerk {

    @Id
    private String ssn;
    private String name;
    private Date joinedDate;
    private Date terminationDate;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean active;

}
