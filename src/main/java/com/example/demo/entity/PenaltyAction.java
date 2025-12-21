package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class PenaltyAction {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String actionTaken;
}
