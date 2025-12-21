package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class IntegrityCase {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String violationType;
private String severity;
}