package com.springboot.journal.journal.rest;

import com.springboot.journal.journal.entity.Child;
import com.springboot.journal.journal.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Rest {
    @Autowired
    private ChildService childService;

    @GetMapping("/childs")
    public List<Child> showAllChild(){
        List<Child> list = childService.showAllChild();
        return  list;
    }

    @GetMapping("/childs/{id}")
    public Child findChildById(@PathVariable int id){
        Child child = childService.getChildById(id);
        return child;
    }

    @PostMapping("/childs")
    public Child addNewChild(@RequestBody Child child){
        childService.saveNewChild(child);
        return child;
    }
}
