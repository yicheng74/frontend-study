package com.exampleforsb.demo.interceptor;
import com.exampleforsb.demo.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.HandlerInterceptor;


public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        if (requestURI.contains("/login")) {
            return true;
        }
        String token = request.getHeader("token");
        token = token.substring(7);
        try {
            Claims claims = JwtUtil.parseToken(token);
            String username = claims.getSubject();
            request.setAttribute("username", username);
            return true;
        } catch (Exception e) {
            response.setStatus(401);
            response.getWriter().write("INVALID TOKEN");
            return false;
        }
    }
}