 package com.example.demo.service;

import com.example.demo.entity.StudentProfile;
import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.RepeatOffenderRecord;

import java.util.List;

public interface RepeatOffenderCalculator {

    void calculate(StudentProfile profile,
                   List<IntegrityCase> cases,
                   RepeatOffenderRecord record);
}
