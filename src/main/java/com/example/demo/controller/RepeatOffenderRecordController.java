package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/repeat-offenders")
public class RepeatOffenderRecordController {

@GetMapping
public String getRepeatOffenders() {
return "Repeat Offender Record Controller Working";
}
}