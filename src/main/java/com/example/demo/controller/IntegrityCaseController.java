package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cases")
public class IntegrityCaseController {

@GetMapping
public String getCases() {
return "Integrity Case Controller Working";
}
}
