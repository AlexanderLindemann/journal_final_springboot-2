package com.springboot.journal.journal.dao;

import com.springboot.journal.journal.entity.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Integer> {
}
