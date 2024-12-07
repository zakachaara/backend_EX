package com.exam.backend_ex.controller;

import com.exam.backend_ex.controller.util.ApiResponse;
import com.exam.backend_ex.dao.GradeDao;
import com.exam.backend_ex.dao.StudentDao;
import com.exam.backend_ex.model.Grade;
import com.exam.backend_ex.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentDao studentDao;

    @GetMapping
    public List<Student> productsList(){
        return studentDao.findAll();
    }

    @PostMapping
    public ApiResponse<Student> createStudent(@RequestBody Student p){
        return new ApiResponse<Student>(HttpStatus.OK.value(), "Student added successfully ", studentDao.save(p));
    }

    @Autowired
    GradeDao gradeDao;

    @GetMapping( value = "/{id}")
    public List<Grade> gradesList(@PathVariable String id){
        return gradeDao.findAllById(id);
    }



    @PostMapping( value = "/{id}")
    public ApiResponse<Grade> createGrade(@PathVariable int id, @RequestBody Grade g){
        Optional<Student> student = studentDao.findById(id);
        if(Objects.isNull(student)) {
            return new ApiResponse<Grade>(HttpStatus.NOT_FOUND.value(), "Student with id: "+id+ " not found", null);
        }
        g.setStudent_id(id);
        return new ApiResponse<Grade>(
                HttpStatus.OK.value(),
                "Grade added successfully",
                gradeDao.save(g));
    }

}
