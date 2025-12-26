package com.example.demo.service.impl;

import com.example.demo.entity.StudentProfile;
import com.example.demo.entity.IntegrityCase;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.StudentProfileService;
import com.example.demo.util.RepeatOffenderCalculator;
import java.util.List;

public class StudentProfileServiceImpl implements StudentProfileService {
    private final StudentProfileRepository repository;
    private final IntegrityCaseRepository caseRepository;
    private final RepeatOffenderRecordRepository recordRepository;
    private final RepeatOffenderCalculator calculator;

    public StudentProfileServiceImpl(StudentProfileRepository repository, IntegrityCaseRepository caseRepository, 
                                     RepeatOffenderRecordRepository recordRepository, RepeatOffenderCalculator calculator) {
        this.repository = repository;
        this.caseRepository = caseRepository;
        this.recordRepository = recordRepository;
        this.calculator = calculator;
    }

    @Override
    public StudentProfile createStudent(StudentProfile student) {
        // Must set to false on creation [cite: 196, 197]
        student.setRepeatOffender(false);
        return repository.save(student);
    }

    @Override
    public StudentProfile getStudentById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
    }

    @Override
    public StudentProfile updateRepeatOffenderStatus(Long studentId) {
        StudentProfile student = getStudentById(studentId);
        List<IntegrityCase> cases = caseRepository.findByStudentProfile(student);
        
        // Logical check for 2 or more cases [cite: 201, 202]
        if (cases.size() >= 2) {
            student.setRepeatOffender(true);
            recordRepository.save(calculator.computeRepeatOffenderRecord(student, cases));
        } else {
            student.setRepeatOffender(false);
        }
        return repository.save(student);
    }
    
    @Override
    public List<StudentProfile> getAllStudents() {
        return repository.findAll();
    }
}