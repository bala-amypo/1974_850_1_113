package com.example.demo.security;

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


