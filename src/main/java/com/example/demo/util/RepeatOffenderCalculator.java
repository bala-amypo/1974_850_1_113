package com.example.demo.util; // Path: src/main/java/com/example/demo/util/RepeatOffenderCalculator.java

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import java.util.List;

public class RepeatOffenderCalculator {
    public RepeatOffenderRecord computeRepeatOffenderRecord(StudentProfile s, List<IntegrityCase> cases) {
        RepeatOffenderRecord record = new RepeatOffenderRecord();
        record.setStudentProfile(s);
        int total = cases.size();
        record.setTotalCases(total);

        // Required for test priorities 36, 37, 38
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