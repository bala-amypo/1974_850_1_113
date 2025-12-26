package com.example.demo.service.impl; // Path: src/main/java/com/example/demo/service/impl/RepeatOffenderRecordServiceImpl.java

import com.example.demo.repository.*;
import com.example.demo.service.RepeatOffenderRecordService;
import com.example.demo.util.RepeatOffenderCalculator;

public class RepeatOffenderRecordServiceImpl implements RepeatOffenderRecordService {
    private final StudentProfileRepository studentRepo;
    private final IntegrityCaseRepository caseRepo;
    private final RepeatOffenderRecordRepository recordRepo;
    private final RepeatOffenderCalculator calculator;

    // Constructor sequence must match the test setup 
    public RepeatOffenderRecordServiceImpl(
            StudentProfileRepository studentRepo, 
            IntegrityCaseRepository caseRepo, 
            RepeatOffenderRecordRepository recordRepo, 
            RepeatOffenderCalculator calculator) {
        this.studentRepo = studentRepo;
        this.caseRepo = caseRepo;
        this.recordRepo = recordRepo;
        this.calculator = calculator;
    }
}