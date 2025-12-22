package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.repository.IntegrityCaseRepository;

@Service
public class IntegrityCaseService {

    private final IntegrityCaseRepository repository;

    public IntegrityCaseService(IntegrityCaseRepository repository) {
        this.repository = repository;
    }
}
