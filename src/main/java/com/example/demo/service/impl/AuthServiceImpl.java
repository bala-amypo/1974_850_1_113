package com.example.demo.service.impl;

import com.example.demo.dto.*;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.AuthService;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AppUserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authManager;
    private final JwtTokenProvider jwtProvider;

    public AuthServiceImpl(AppUserRepository u, RoleRepository r,
                           PasswordEncoder e, AuthenticationManager a,
                           JwtTokenProvider j) {
        this.userRepo = u;
        this.roleRepo = r;
        this.encoder = e;
        this.authManager = a;
        this.jwtProvider = j;
    }

    @Override
    public void register(RegisterRequest r) {
        if (userRepo.existsByEmail(r.email))
            throw new IllegalArgumentException("Email already exists");

        Role role = roleRepo.findByName(r.role)
                .orElseThrow(() -> new IllegalArgumentException("Role not found"));

        AppUser user = new AppUser(r.fullName, r.email, encoder.encode(r.password));
        user.getRoles().add(role);

        userRepo.save(user);
    }

    @Override
    public JwtResponse login(LoginRequest req) {
        authManager.authenticate(
            new UsernamePasswordAuthenticationToken(req.email, req.password)
        );

        AppUser user = userRepo.findByEmail(req.email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        String role = user.getRoles().iterator().next().getName();
        String token = jwtProvider.generateToken(req.email, user.getId(), role);

        JwtResponse res = new JwtResponse();
        res.token = token;
        res.userId = user.getId();
        res.email = user.getEmail();
        res.role = role;

        return res;
    }
}
