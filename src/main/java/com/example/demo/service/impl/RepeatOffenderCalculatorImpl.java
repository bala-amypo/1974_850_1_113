package com.example.demo.service.impl;

import com.example.demo.entity.StudentProfile;
import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.service.RepeatOffenderCalculator;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RepeatOffenderCalculatorImpl
        implements RepeatOffenderCalculator {

    @Override
    public void calculate(StudentProfile profile,
                          List<IntegrityCase> cases,
                          RepeatOffenderRecord record) {

        int total = cases.size();
        record.setStudentProfile(profile);
        record.setTotalCases(total);

        if (total >= 4) {
            record.setFlagSeverity("HIGH");
            profile.setRepeatOffender(true);
        } else if (total == 2) {
            record.setFlagSeverity("MEDIUM");
            profile.setRepeatOffender(true);
        } else if (total == 1) {
            record.setFlagSeverity("LOW");
            profile.setRepeatOffender(false);
        } else {
            record.setFlagSeverity("NONE");
            profile.setRepeatOffender(false);
        }
    }
}
