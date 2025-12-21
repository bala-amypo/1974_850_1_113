

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
 
package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class PenaltyAction {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String actionTaken;
}

entity/RepeatOffenderRecord.java
 
package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class RepeatOffenderRecord {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private int riskLevel;
}


