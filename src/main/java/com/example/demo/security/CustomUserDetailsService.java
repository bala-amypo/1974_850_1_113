package com.example.demo.security;

@Service

public class CustomUserDetailsService implements UserDetailsService {

@Override
public UserDetails loadUserByUsername(String username) {
return new User(username, "password", new ArrayList<>());
}
}