package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class EvidenceRecord {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String description;
}



