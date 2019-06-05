package com.nsv.jsmbaba.hibernate.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name="reviewer" , schema = "javatraining")
public class Reviewer {
    @Id
    @GeneratedValue
    @Column(name="reviewer_id")
    private int reviewerId;
    @Column(name="name")
    private String reviewerName;

    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name="reviewer_task",
               joinColumns = {@JoinColumn(name="reviewer_id")},
               inverseJoinColumns = {@JoinColumn(name = "task_id")})
    private List<Task> tasks = new ArrayList<>();
}
