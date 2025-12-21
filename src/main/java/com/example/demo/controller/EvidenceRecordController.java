

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


✅ EXCEPTION PACKAGE (AS IN YOUR IMAGE)

ResourceNotFoundException.java



GlobalExceptionHandler.java


🔹 5. REPOSITORY FILES
 
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.*;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {}
public interface IntegrityCaseRepository extends JpaRepository<IntegrityCase, Long> {}
public interface EvidenceRecordRepository extends JpaRepository<EvidenceRecord, Long> {}
public interface PenaltyActionRepository extends JpaRepository<PenaltyAction, Long> {}
public interface RepeatOffenderRecordRepository extends JpaRepository<RepeatOffenderRecord, Long> {}

(In IDE, keep one interface per file)


