package com.jp.prestamosjava.servlet;

import jakarta.servlet.*;

import java.io.IOException;

public class MonitoringFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long before = System.currentTimeMillis();
        String action = request.getParameter("action");
        chain.doFilter(request, response);
        long after = System.currentTimeMillis();
        System.out.println("Execution of " + action + " in " + (after-before));
    }
}
