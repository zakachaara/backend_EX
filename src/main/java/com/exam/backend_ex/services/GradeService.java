package com.exam.backend_ex.services;

import com.exam.backend_ex.dao.GradeDao;
import com.exam.backend_ex.model.Grade;
import com.exam.backend_ex.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {

    @Autowired
    private GradeDao gradeDao;

    @Autowired
    private StudentService studentService;

    public List<Grade> getGradesByStudentId(Long studentId) {
        return gradeDao.findByStudentId(studentId);
    }

    public Grade addGradeToStudent(Long studentId, Grade grade) {
        Student student = studentService.getStudentById(studentId);


        student.addGrade(grade);


        studentService.saveStudent(student);

        return grade;
    }
}
