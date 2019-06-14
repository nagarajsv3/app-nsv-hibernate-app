package com.nsv.jsmbaba.hibernate.domain.inheritencetype.singletable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Entity
@Table(name="cd")
@DiscriminatorValue("InternationalCd")
public class InternationalCd extends Cd {
    private String languages;
    private int region;
}
