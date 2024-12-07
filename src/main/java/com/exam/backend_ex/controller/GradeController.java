package com.exam.backend_ex.controller;

import com.exam.backend_ex.controller.util.ApiResponse;
import com.exam.backend_ex.dao.GradeDao;

import com.exam.backend_ex.model.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class GradeController {
    @Autowired
    GradeDao gradeDao;

    @GetMapping( value = "/{id}")
    public List<Grade> gradesList(@PathVariable String id){
        return gradeDao.findAllById(id);
    }



    @PostMapping
    public ApiResponse<Grade> createGrade(@RequestBody Grade p){
        return new ApiResponse<Grade>(HttpStatus.OK.value(), "Grade added successfully ", gradeDao.save(p));
    }

}
