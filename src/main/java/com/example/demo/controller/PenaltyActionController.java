package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/penalties")
public class PenaltyActionController {

@GetMapping
public String getPenalties() {
return "Penalty Action Controller Working";
}
}