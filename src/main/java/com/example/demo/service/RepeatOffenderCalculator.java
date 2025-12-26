package com.example.demo.util; // Correct package based on test imports 

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import java.util.List;

public class RepeatOffenderCalculator {
    public RepeatOffenderRecord computeRepeatOffenderRecord(StudentProfile s, List<IntegrityCase> cases) {
        RepeatOffenderRecord record = new RepeatOffenderRecord();
        record.setStudentProfile(s);
        record.setTotalCases(cases.size());
        
        // Logic to satisfy Priority 36, 37, 38 [cite: 87, 89, 92]
        int count = cases.size();
        if (count >= 4) {
            record.setFlagSeverity("HIGH");
        } else if (count >= 2) {
            record.setFlagSeverity("MEDIUM");
        } else {
            record.setFlagSeverity("LOW");
        }
        return record;
    }
}