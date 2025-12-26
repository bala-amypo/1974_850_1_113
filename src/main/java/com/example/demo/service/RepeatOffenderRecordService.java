package com.example.demo.service.impl;

import com.example.demo.repository.*;
import com.example.demo.service.RepeatOffenderRecordService;
import com.example.demo.util.RepeatOffenderCalculator;
import com.example.demo.entity.StudentProfile;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.IntegrityCase;
import java.util.List;

public class RepeatOffenderRecordServiceImpl implements RepeatOffenderRecordService {
    private final StudentProfileRepository studentRepo;
    private final IntegrityCaseRepository caseRepo;
    private final RepeatOffenderRecordRepository recordRepo;
    private final RepeatOffenderCalculator calculator;

    public RepeatOffenderRecordServiceImpl(StudentProfileRepository studentRepo, 
                                          IntegrityCaseRepository caseRepo, 
                                          RepeatOffenderRecordRepository recordRepo, 
                                          RepeatOffenderCalculator calculator) {
        this.studentRepo = studentRepo;
        this.caseRepo = caseRepo;
        this.recordRepo = recordRepo;
        this.calculator = calculator;
    }

    // Example method required for Priority 49 [cite: 254]
    public RepeatOffenderRecord updateAndGetRecord(Long studentId) {
        StudentProfile student = studentRepo.findById(studentId).orElseThrow();
        List<IntegrityCase> cases = caseRepo.findByStudentProfile(student);
        RepeatOffenderRecord record = calculator.computeRepeatOffenderRecord(student, cases);
        return recordRepo.save(record);
    }
}