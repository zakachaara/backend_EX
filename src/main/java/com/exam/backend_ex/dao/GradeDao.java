package com.exam.backend_ex.dao;

import com.exam.backend_ex.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GradeDao extends JpaRepository<Grade, Integer> {
    List<Grade> findByStudentId(Long studentId);
}
