package com.springboot.journal.journal.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "marks")
public class Mark {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private int mark;

    @ManyToMany
    @JoinTable(
            name = "child_mark"
            , joinColumns = @JoinColumn( name = "mark_id")
            , inverseJoinColumns = @JoinColumn (name = "child_id")
    )
    private List<Child> childs;

    public void addChildToMark(Child child){
        if(childs == null){
            childs = new ArrayList<>();
        }
        childs.add(child);
    }
}
