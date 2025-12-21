package com.example.demo.service;

@Service
public class IntegrityCaseService {

private final IntegrityCaseRepository repo;

public IntegrityCaseService(IntegrityCaseRepository repo) {
this.repo = repo;
}
}