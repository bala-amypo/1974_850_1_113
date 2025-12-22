package com.example.demo.service;

import com.example.demo.entity.IntegrityCase;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class RepeatOffenderCalculator {
    
    public String calculateSeverity(int totalCases) {
        if (totalCases >= 4) return "HIGH";
        if (totalCases == 2 || totalCases == 3) return "MEDIUM";
        return "LOW";
    }
    
    public boolean isRepeatOffender(List<IntegrityCase> cases) {
        return cases.size() >= 2;
    }
}