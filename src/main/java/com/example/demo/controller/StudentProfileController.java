package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentProfileController {
    private final StudentProfileService studentProfileService;

    public StudentProfileController(StudentProfileService studentProfileService) {
        this.studentProfileService = studentProfileService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createStudent(@RequestBody StudentProfile studentProfile) {
        StudentProfile created = studentProfileService.createStudent(studentProfile);
        return ResponseEntity.ok(new ApiResponse(true, "Student created successfully", created));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getStudent(@PathVariable Long id) {
        StudentProfile student = studentProfileService.getStudentById(id);
        return ResponseEntity.ok(new ApiResponse(true, "Student found", student));
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllStudents() {
        List<StudentProfile> students = studentProfileService.getAllStudents();
        return ResponseEntity.ok(new ApiResponse(true, "Students retrieved", students));
    }

    @PutMapping("/{id}/repeat-offender")
    public ResponseEntity<ApiResponse> updateRepeatOffenderStatus(@PathVariable Long id) {
        StudentProfile updated = studentProfileService.updateRepeatOffenderStatus(id);
        return ResponseEntity.ok(new ApiResponse(true, "Repeat offender status updated", updated));
    }
}