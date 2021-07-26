package com.springboot.journal.journal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@AllArgsConstructor
@Data
@Entity
@Table(name = "childs")
public class Child implements Comparable<Child> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private int age;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToMany
    @JoinTable(
            name = "child_mark"
            , joinColumns = @JoinColumn(name = "child_id")
            , inverseJoinColumns = @JoinColumn(name = "mark_id")
    )
    private List<Mark> marks;

    public Child(String name, String surname, int age) {
    }

    public Child() {

    }

    @ManyToMany
    @JoinTable(
            name = "child_section"
            , joinColumns = @JoinColumn(name = "child_id")
            , inverseJoinColumns = @JoinColumn(name = "section_id")
    )
    private List<Section> sections;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    private void addSectionToChild(Section section) {
        if (sections == null) {
            sections = new ArrayList<>();
        }
        sections.add(section);
    }

    public void addMarkToChild(Mark mark) {
        if (marks == null) {
            marks = new ArrayList<>();
        }
        marks.add(mark);
    }

    @Override
    public int compareTo(Child o) {
        return this.getId() - o.getId();
    }

    public static class NameComparator implements Comparator<Child> {

        @Override
        public int compare(Child o1, Child o2) {
            return (o1.getName() + o1.getSurname()).compareTo(o2.getName() + o2.getSurname());
        }
    }
}

