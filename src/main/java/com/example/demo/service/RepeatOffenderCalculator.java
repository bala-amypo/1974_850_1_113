package com.example.demo.util;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import java.util.List;

public class RepeatOffenderCalculator {

    public RepeatOffenderRecord computeRepeatOffenderRecord(StudentProfile student, List<IntegrityCase> cases) {
        RepeatOffenderRecord record = new RepeatOffenderRecord();
        record.setStudentProfile(student);
        int total = cases.size();
        record.setTotalCases(total);

        // Logic based on Priority 36-38 [cite: 234, 236, 238]
        if (total >= 4) {
            record.setFlagSeverity("HIGH");
        } else if (total >= 2) {
            record.setFlagSeverity("MEDIUM");
        } else {
            record.setFlagSeverity("LOW");
        }
        return record;
    }
}