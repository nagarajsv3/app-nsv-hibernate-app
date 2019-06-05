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
@Table(name="task", schema = "javatraining")
public class Task {
    @Id
    @GeneratedValue
    @Column(name="task_id")
    private int taskId;
    @Column(name="name")
    private String taskName;

    @ManyToMany(mappedBy = "tasks")
    private List<Reviewer> reviewers = new ArrayList<>();
}
