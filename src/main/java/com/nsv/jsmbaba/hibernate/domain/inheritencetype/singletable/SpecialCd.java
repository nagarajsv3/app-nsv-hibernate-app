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
@DiscriminatorValue("SpecialCd")
public class SpecialCd extends Cd {
    private String newFeatures;

}
