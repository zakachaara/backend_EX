package com.exam.backend_ex.model;

public class Grade {
    int student_id;
    String nom_module = null ;
    Double note = null ;
    public Grade(int id , String nom_module, Double note) {
        this.student_id = id ;
        this.nom_module = nom_module ;
        this.note = note ;
    }
    public int getStudent_id() {
        return student_id;
    }
    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }
    public String getNom_module() {
        return nom_module;
    }
    public void setNom_module(String nom_module) {
        this.nom_module = nom_module ;
    }
}
