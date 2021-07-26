package com.springboot.journal.journal;

import com.springboot.journal.journal.entity.Child;
import com.springboot.journal.journal.entity.Group;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class JournalApplication {

    public static void main(String[] args) {
        SpringApplication.run(JournalApplication.class, args);
        Group group = new Group();

        Child child1 = new Child("Alexander", "Lindemann", 31);
        Child child2 = new Child("Pavel", "Lemeshev", 20);
        Child child3 = new Child("Olesya", "Svezhinskaya", 25);

        List<Child> childList = new ArrayList<>();
        childList.add(child1);
        childList.add(child2);
        childList.add(child3);

        System.out.println(childList + "before");

        Collections.sort(childList);
        childList.sort(new Child.NameComparator());

        System.out.println(childList + "after");
    }

}
