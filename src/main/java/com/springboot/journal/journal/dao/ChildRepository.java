package com.springboot.journal.journal.dao;

import com.springboot.journal.journal.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildRepository extends JpaRepository<Child, Integer> {
    public Child findAllByName(String name);
}
