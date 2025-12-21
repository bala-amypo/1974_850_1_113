package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentProfileController {

@GetMapping
public String getStudents() {
return "Student Profile Controller Working";
}
}