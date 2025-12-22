package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class RepeatOffenderRecordService {

    public int computeRepeatOffenderRecord(int cases) {
        if (cases <= 1) return 1;
        if (cases == 2) return 2;
        return 4;
    }
}
