package com.example.demo.service.impl;

import com.example.demo.entity.PenaltyAction;
import com.example.demo.entity.IntegrityCase;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.PenaltyActionRepository;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.service.PenaltyActionService;
import org.springframework.stereotype.Service;

@Service
public class PenaltyActionServiceImpl implements PenaltyActionService {

    private final PenaltyActionRepository penaltyRepo;
    private final IntegrityCaseRepository caseRepo;

    public PenaltyActionServiceImpl(PenaltyActionRepository penaltyRepo,
                                    IntegrityCaseRepository caseRepo) {
        this.penaltyRepo = penaltyRepo;
        this.caseRepo = caseRepo;
    }

    @Override
    public PenaltyAction addPenalty(PenaltyAction penalty) {
        if (penalty.getIntegrityCase() == null ||
            penalty.getIntegrityCase().getId() == null) {
            throw new IllegalArgumentException("Case reference required");
        }

        IntegrityCase integrityCase = caseRepo.findById(
                penalty.getIntegrityCase().getId()
        ).orElseThrow(() -> new ResourceNotFoundException("Case not found"));

        integrityCase.setStatus("UNDER_REVIEW");
        caseRepo.save(integrityCase);

        penalty.setIntegrityCase(integrityCase);
        return penaltyRepo.save(penalty);
    }
}
