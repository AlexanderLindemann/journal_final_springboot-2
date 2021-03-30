package com.springboot.journal.journal.service;


import com.springboot.journal.journal.entity.Child;

import java.util.List;

public interface ChildService {
    public List<Child> showAllChild();

    public Child getChildById(int id);

    public void deleteChildById(int id);

    public Child updateChild(Child child);

    public void saveNewChild(Child child);
}
