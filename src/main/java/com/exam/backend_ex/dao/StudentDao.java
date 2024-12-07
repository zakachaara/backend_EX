package com.exam.backend_ex.dao;

import com.exam.backend_ex.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {
}


