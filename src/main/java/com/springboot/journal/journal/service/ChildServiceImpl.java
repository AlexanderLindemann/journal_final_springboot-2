package com.springboot.journal.journal.service;

import com.springboot.journal.journal.dao.ChildRepository;
import com.springboot.journal.journal.entity.Child;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChildServiceImpl implements ChildService {

    @Autowired
    private ChildRepository childRepository;

    @Override
    public List<Child> showAllChild() {
        return childRepository.findAll();
    }

    @Override
    public Child getChildById(int id) {
        Child child = null;
        Optional<Child> childOptional = childRepository.findById(id);
        if(childOptional.isPresent()){
            child = childOptional.get();
        }
        return child;
    }

    @Override
    public void deleteChildById(int id) {
         childRepository.deleteById(id);
    }

    @Override
    public Child updateChild(Child child) {
        return childRepository.save(child);
    }

    @Override
    public void saveNewChild(Child child) {
        childRepository.save(child);
    }
}
