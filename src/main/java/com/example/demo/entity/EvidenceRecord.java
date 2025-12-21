🔹 4. ENTITY FILES
entity/StudentProfile.java
 
package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class StudentProfile {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String studentName;
private String registerNumber;

// getters & setters
}

entity/IntegrityCase.java
 


entity/EvidenceRecord.java
 
package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class EvidenceRecord {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String description;
}

entity/PenaltyAction.java
 

entity/RepeatOffenderRecord.java
 


