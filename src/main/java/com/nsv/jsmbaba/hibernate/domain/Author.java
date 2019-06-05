package com.nsv.jsmbaba.hibernate.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Getter
@Setter
@ToString
@Entity
@Table(name = "author", schema = "javatraining")
public class Author {

    @Id
    private CompositeKeyAuthor compositeKeyAuthor;

    private String middleName;
    private String isbn;

    @Version
    private int versionId;

}
