package com.springboot.journal.journal.entity;



import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "sections")
public class Section {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String selection;

    @ManyToMany
    @JoinTable(
            name = "child_section"
            ,joinColumns = @JoinColumn(name = "section_id")
            ,inverseJoinColumns = @JoinColumn(name = "child_id")
    )
    private List<Child> childs;

    public void addChildToSection(Child child){
        if(childs == null){
            childs = new ArrayList<>();
        }
        childs.add(child);
    }
}
