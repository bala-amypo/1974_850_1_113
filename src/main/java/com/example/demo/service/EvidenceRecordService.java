package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.repository.EvidenceRecordRepository;

@Service
public class EvidenceRecordService {

    private final EvidenceRecordRepository repository;

    public EvidenceRecordService(EvidenceRecordRepository repository) {
        this.repository = repository;
    }
}
