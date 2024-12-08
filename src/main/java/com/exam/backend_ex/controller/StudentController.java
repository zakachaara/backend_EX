package com.exam.backend_ex.controller;

import com.exam.backend_ex.model.Grade;
import com.exam.backend_ex.model.Student;
import com.exam.backend_ex.model.StudentDto;
import com.exam.backend_ex.services.GradeService;
import com.exam.backend_ex.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private GradeService gradeService;

    @GetMapping("/")
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents().stream()
                .map(student -> new StudentDto(
                        student.getId(),
                        student.getName(),
                        student.getDateCreation(),
                        student.getGrades().stream().mapToDouble(Grade::getNote).average().orElse(0.0)
                )).collect(Collectors.toList());
    }

    @PostMapping("/")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/{id}/grades")
    public List<Grade> getGradesForStudent(@PathVariable Long id) {
        return gradeService.getGradesByStudentId(id);
    }

    @PostMapping("/{id}/grades")
    public ResponseEntity<Grade> addGradeToStudent(@PathVariable Long id, @RequestBody Grade grade) {
        Grade newGrade = gradeService.addGradeToStudent(id, grade);
        return ResponseEntity.ok(newGrade);

    }
}
