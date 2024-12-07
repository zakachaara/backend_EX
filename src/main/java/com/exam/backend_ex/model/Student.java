package com.exam.backend_ex.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Student")
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "Date_Creation")
    private LocalDateTime dateCreation = LocalDateTime.now();
    @Column(name = "Note Globale")
    private double note;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Grade> grades;
    public Student( String name, double note) {
        this.name = name;
        this.note = note;

    }
    public Student() {}
}
