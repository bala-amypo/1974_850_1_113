package com.example.demo.service;

@Service
public class PenaltyActionService {

private final PenaltyActionRepository repo;

public PenaltyActionService(PenaltyActionRepository repo) {
this.repo = repo;
}
}
