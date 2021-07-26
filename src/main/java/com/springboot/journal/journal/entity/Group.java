package com.springboot.journal.journal.entity;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name_group;

    @OneToMany(mappedBy = "group")
    private List<Child> childList;

    public void addChildInGroup(Child child){
        if(childList == null){
            childList = new ArrayList<>();
        }
        childList.add(child);
        child.setGroup(this);
    }

    public int getId() {
        return id;
    }

    public String getName_group() {
        return name_group;
    }
}
