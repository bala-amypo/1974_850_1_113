package com.example.demo.service.impl;

import com.example.demo.entity.PenaltyAction;
import com.example.demo.entity.IntegrityCase;
import com.example.demo.repository.*;
import com.example.demo.service.PenaltyActionService;

public class PenaltyActionServiceImpl implements PenaltyActionService {
    private final PenaltyActionRepository penaltyRepository;
    private final IntegrityCaseRepository caseRepository;

    public PenaltyActionServiceImpl(PenaltyActionRepository pr, IntegrityCaseRepository cr) {
        this.penaltyRepository = pr;
        this.caseRepository = cr;
    }

    @Override
    public PenaltyAction addPenalty(PenaltyAction penalty) {
        IntegrityCase c = penalty.getIntegrityCase();
        // Requirement for test priority 23 [cite: 218]
        c.setStatus("UNDER_REVIEW");
        caseRepository.save(c);
        return penaltyRepository.save(penalty);
    }
}