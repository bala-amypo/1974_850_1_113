package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "integrity_cases")
public class IntegrityCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_profile_id")
    private StudentProfile studentProfile;

    private String courseCode;
    private String instructorName;
    private String description;

    @Column(nullable = false)
    private String status = "OPEN";

    private LocalDate incidentDate;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "integrityCase", cascade = CascadeType.ALL)
    private List<EvidenceRecord> evidenceRecords = new ArrayList<>();

    @OneToMany(mappedBy = "integrityCase", cascade = CascadeType.ALL)
    private List<PenaltyAction> penaltyActions = new ArrayList<>();

    public IntegrityCase() {}

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public StudentProfile getStudentProfile() { return studentProfile; }
    public void setStudentProfile(StudentProfile studentProfile) { this.studentProfile = studentProfile; }
    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }
    public String getInstructorName() { return instructorName; }
    public void setInstructorName(String instructorName) { this.instructorName = instructorName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDate getIncidentDate() { return incidentDate; }
    public void setIncidentDate(LocalDate incidentDate) { this.incidentDate = incidentDate; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public List<EvidenceRecord> getEvidenceRecords() { return evidenceRecords; }
    public void setEvidenceRecords(List<EvidenceRecord> evidenceRecords) { this.evidenceRecords = evidenceRecords; }
    public List<PenaltyAction> getPenaltyActions() { return penaltyActions; }
    public void setPenaltyActions(List<PenaltyAction> penaltyActions) { this.penaltyActions = penaltyActions; }
}