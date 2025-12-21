package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evidence")
public class EvidenceRecordController {

@GetMapping
public String getEvidence() {
return "Evidence Record Controller Working";
}
}


