package com.empmanagement.employee_service.filter;

import com.empmanagement.employee_service.service.TokenService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomFilter implements Filter {

    @Autowired
    TokenService tokenService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String authHeader = httpRequest.getHeader("Authorization");
        if (httpRequest.getRequestURI().startsWith("/h2-console") == true) {
            chain.doFilter(request, response);
            return;
        }

        if ("POST".equalsIgnoreCase(httpRequest.getMethod())
                &&
                (
                        httpRequest.getRequestURI().startsWith("/User")
                                || httpRequest.getRequestURI().startsWith("/auth")
                )
        ) {
            chain.doFilter(request, response);

        } else {
            System.out.println("Filtering POST request to");
            if (tokenService.veriyfyToken(authHeader)) {
                chain.doFilter(request, response);
            } else {
                httpResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
            }
        }
    }
}
