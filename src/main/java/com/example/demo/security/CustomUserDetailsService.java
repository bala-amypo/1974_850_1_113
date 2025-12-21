🔹 8. SECURITY FILES (EXACT NAMES)
security/JwtTokenProvider.java



security/JwtAuthenticationFilter.java


security/JwtAuthenticationEntryPoint.java


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




