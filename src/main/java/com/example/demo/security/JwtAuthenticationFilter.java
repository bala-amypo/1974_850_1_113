package com.example.demo.security;

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


