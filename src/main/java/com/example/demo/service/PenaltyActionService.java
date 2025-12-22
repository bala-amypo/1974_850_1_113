package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.repository.PenaltyActionRepository;

@Service
public class PenaltyActionService {

    private final PenaltyActionRepository repository;

    public PenaltyActionService(PenaltyActionRepository repository) {
        this.repository = repository;
    }
}
