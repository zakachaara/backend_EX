package com.exam.backend_ex.services;

import com.exam.backend_ex.dao.StudentDao;
import com.exam.backend_ex.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    public Student addStudent(Student student) {
        return studentDao.save(student);
    }

    public Student getStudentById(Long id) {
        return studentDao.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));
    }
}
