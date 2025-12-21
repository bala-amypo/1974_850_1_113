

📁 controller/IntegrityCaseController.java
 


📁 controller/EvidenceRecordController.java
 
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


📁 controller/PenaltyActionController.java
 



📁 controller/RepeatOffenderRecordController.java
 


🔹 3. DTO FILES

LoginRequest.java
 
package com.example.demo.dto;

public class LoginRequest {
private String username;
private String password;

public String getUsername() { return username; }
public void setUsername(String username) { this.username = username; }

public String getPassword() { return password; }
public void setPassword(String password) { this.password = password; }
}



dto/RegisterRequest.java
 
package com.example.demo.dto;

public class RegisterRequest {
private String username;
private String password;

public String getUsername() { return username; }
public void setUsername(String username) { this.username = username; }

public String getPassword() { return password; }
public void setPassword(String password) { this.password = password; }
}


dto/JwtResponse.java
 
package com.example.demo.dto;

public class JwtResponse {
private String token;

public JwtResponse(String token) {
this.token = token;
}

public String getToken() {
return token;
}
}


🔹 4. ENTITY FILES
entity/StudentProfile.java
 
package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class StudentProfile {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String studentName;
private String registerNumber;

// getters & setters
}

entity/IntegrityCase.java
 
package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class IntegrityCase {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String violationType;
private String severity;
}

entity/EvidenceRecord.java
 
package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class EvidenceRecord {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String description;
}

entity/PenaltyAction.java
 
package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class PenaltyAction {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String actionTaken;
}

entity/RepeatOffenderRecord.java
 
package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class RepeatOffenderRecord {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private int riskLevel;
}


✅ EXCEPTION PACKAGE (AS IN YOUR IMAGE)

ResourceNotFoundException.java

package com.example.demo.exception;

public class ResourceNotFoundException extends RuntimeException {

public ResourceNotFoundException(String message) {
super(message);
}
}



GlobalExceptionHandler.java

package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<String> handleResourceNotFound(
ResourceNotFoundException ex) {
return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
}

@ExceptionHandler(Exception.class)
public ResponseEntity<String> handleGeneralException(Exception ex) {
return new ResponseEntity<>("Internal Server Error",
HttpStatus.INTERNAL_SERVER_ERROR);
}
}

🔹 5. REPOSITORY FILES
 
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.*;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {}
public interface IntegrityCaseRepository extends JpaRepository<IntegrityCase, Long> {}
public interface EvidenceRecordRepository extends JpaRepository<EvidenceRecord, Long> {}
public interface PenaltyActionRepository extends JpaRepository<PenaltyAction, Long> {}
public interface RepeatOffenderRecordRepository extends JpaRepository<RepeatOffenderRecord, Long> {}

(In IDE, keep one interface per file)


🔹 8. SECURITY FILES (EXACT NAMES)
security/JwtTokenProvider.java

package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {
public String generateToken(String username) {
return username + "_token";
}
}

security/JwtAuthenticationFilter.java

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

@Override
protected void doFilterInternal(HttpServletRequest req,
HttpServletResponse res,
FilterChain chain)
throws IOException, ServletException {
chain.doFilter(req, res);
}
}

security/JwtAuthenticationEntryPoint.java

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

@Override
public void commence(HttpServletRequest req,
HttpServletResponse res,
AuthenticationException ex)
throws IOException {
res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
}
}

security/CustomUserDetailsService.java

@Service
public class CustomUserDetailsService implements UserDetailsService {

@Override
public UserDetails loadUserByUsername(String username) {
return new User(username, "password", new ArrayList<>());
}
}

security/SecurityConfig.java

@Configuration
@EnableWebSecurity
public class SecurityConfig {

@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
http.csrf().disable()
.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
return http.build();
}
}


🔹 6. SERVICE FILES (Constructor Injection ✔)
service/StudentProfileService.java
 
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

service/IntegrityCaseService.java
 
@Service
public class IntegrityCaseService {

private final IntegrityCaseRepository repo;

public IntegrityCaseService(IntegrityCaseRepository repo) {
this.repo = repo;
}
}

service/EvidenceRecordService.java
 
@Service
public class EvidenceRecordService {

private final EvidenceRecordRepository repo;

public EvidenceRecordService(EvidenceRecordRepository repo) {
this.repo = repo;
}
}

service/PenaltyActionService.java
 
@Service
public class PenaltyActionService {

private final PenaltyActionRepository repo;

public PenaltyActionService(PenaltyActionRepository repo) {
this.repo = repo;
}
}

service/RepeatOffenderRecordService.java
 
@Service
public class RepeatOffenderRecordService {

public int computeRepeatOffenderRecord(int cases) {
if (cases <= 1) return 1;
if (cases == 2) return 2;
return 4;
}
}




🔹 9. SERVLET (VERY IMPORTANT ✔)
servlet/BasicServlet.java
 
package com.example.demo.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/basic")
public class BasicServlet extends HttpServlet {

@Override
protected void doGet(HttpServletRequest req,
HttpServletResponse resp) throws IOException {
resp.getWriter().write("Servlet is running");
}

@Override
protected void doPost(HttpServletRequest req,
HttpServletResponse resp) throws IOException {
resp.getWriter().write("Servlet POST handled");
}
}


