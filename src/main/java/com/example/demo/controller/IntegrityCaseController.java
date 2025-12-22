package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.IntegrityCase;
import com.example.demo.service.IntegrityCaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cases")
public class IntegrityCaseController {
    private final IntegrityCaseService integrityCaseService;

    public IntegrityCaseController(IntegrityCaseService integrityCaseService) {
        this.integrityCaseService = integrityCaseService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createCase(@RequestBody IntegrityCase integrityCase) {
        IntegrityCase created = integrityCaseService.createCase(integrityCase);
        return ResponseEntity.ok(new ApiResponse(true, "Case created successfully", created));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<ApiResponse> updateStatus(@PathVariable Long id, @RequestParam String status) {
        IntegrityCase updated = integrityCaseService.updateCaseStatus(id, status);
        return ResponseEntity.ok(new ApiResponse(true, "Case status updated", updated));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<ApiResponse> getCasesByStudent(@PathVariable Long studentId) {
        List<IntegrityCase> cases = integrityCaseService.getCasesByStudent(studentId);
        return ResponseEntity.ok(new ApiResponse(true, "Cases retrieved", cases));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getCaseById(@PathVariable Long id) {
        IntegrityCase integrityCase = integrityCaseService.getCaseById(id)
                .orElseThrow(() -> new RuntimeException("Case not found"));
        return ResponseEntity.ok(new ApiResponse(true, "Case found", integrityCase));
    }
}