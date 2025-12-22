package com.example.demo.service.impl;

import com.example.demo.entity.StudentProfile;
import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.repository.RepeatOffenderRecordRepository;
import com.example.demo.service.RepeatOffenderRecordService;
import com.example.demo.service.RepeatOffenderCalculator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepeatOffenderRecordServiceImpl implements RepeatOffenderRecordService {

    private final StudentProfileRepository studentRepo;
    private final IntegrityCaseRepository caseRepo;
    private final RepeatOffenderRecordRepository repeatRepo;
    private final RepeatOffenderCalculator calculator;

    public RepeatOffenderRecordServiceImpl(StudentProfileRepository studentRepo,
                                           IntegrityCaseRepository caseRepo,
                                           RepeatOffenderRecordRepository repeatRepo,
                                           RepeatOffenderCalculator calculator) {
        this.studentRepo = studentRepo;
        this.caseRepo = caseRepo;
        this.repeatRepo = repeatRepo;
        this.calculator = calculator;
    }

    @Override
    public RepeatOffenderRecord recalculate(Long studentId) {
        StudentProfile profile = studentRepo.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("StudentProfile not found"));

        List<IntegrityCase> cases =
                caseRepo.findByStudentProfile_Id(studentId);

        RepeatOffenderRecord record =
                repeatRepo.findByStudentProfile(profile)
                        .orElse(new RepeatOffenderRecord());

        calculator.calculate(profile, cases, record);

        return repeatRepo.save(record);
    }
}
