package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class StudentProfile {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String studentName;
private String registerNumber;


}