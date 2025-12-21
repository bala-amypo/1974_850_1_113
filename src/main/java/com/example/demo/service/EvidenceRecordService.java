package com.example.demo.service;

@Service
public class EvidenceRecordService {

private final EvidenceRecordRepository repo;

public EvidenceRecordService(EvidenceRecordRepository repo) {
this.repo = repo;
}
}