package com.example.demo.repository;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface IntegrityCaseRepository extends JpaRepository<IntegrityCase, Long> {

    // Required for StudentProfileServiceImpl to calculate repeat offenders 
    List<IntegrityCase> findByStudentProfile(StudentProfile studentProfile);

    // Required for Priority 19: find cases by Student ID [cite: 63]
    List<IntegrityCase> findByStudentProfile_Id(Long studentId);

    // Required for Priority 65: HQL/HCQL advanced querying [cite: 136]
    @Query("SELECT c FROM IntegrityCase c WHERE c.studentProfile.studentId = :studentId")
    List<IntegrityCase> findByStudentIdentifier(@Param("studentId") String studentId);

    // Required for Priority 66: Recent cases by status [cite: 139]
    @Query("SELECT c FROM IntegrityCase c WHERE c.status = :status AND c.incidentDate >= :date")
    List<IntegrityCase> findRecentCasesByStatus(@Param("status") String status, @Param("date") LocalDate date);
    
    // Required for Priority 69: Date range query [cite: 144]
    List<IntegrityCase> findByIncidentDateBetween(LocalDate start, LocalDate end);

    // Required for Priority 70: Status filter [cite: 146]
    List<IntegrityCase> findByStatus(String status);
}