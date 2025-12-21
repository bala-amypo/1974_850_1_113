package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.repository.StudentProfileRepository;

@Service
public class StudentProfileService {

private final StudentProfileRepository repo;

public StudentProfileService(StudentProfileRepository repo) {
this.repo = repo;
}
}