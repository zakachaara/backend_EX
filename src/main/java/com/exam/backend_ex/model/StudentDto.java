package com.exam.backend_ex.model;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StudentDto {
    private int id;
    private String name;
    private LocalDateTime creationDate;
    private double meanGrade;

    public StudentDto(int id, String name, LocalDateTime creationDate, double meanGrade) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.meanGrade = meanGrade;
    }

}

