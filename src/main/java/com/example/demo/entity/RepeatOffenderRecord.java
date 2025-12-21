package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class RepeatOffenderRecord {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private int riskLevel;
}
