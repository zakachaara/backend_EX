package com.exam.backend_ex.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Date dateCreation;
    private double note;
    public Student( String name, double note) {
        this.name = name;
        this.note = note;
        this.dateCreation = new Date();
    }
    public Student() {}
}
