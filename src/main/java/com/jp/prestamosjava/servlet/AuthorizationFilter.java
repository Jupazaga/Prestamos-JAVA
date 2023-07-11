package com.jp.prestamosjava.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AuthorizationFilter implements Filter {
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        String actionParameter = request.getParameter("action");
        System.out.println("Action Authorization: "+actionParameter);
        boolean logged = session.getAttribute("loginUser") != null;
        boolean pageUnprotected = actionParameter.equals("Login") || actionParameter.equals("SignUp");

        if (logged || pageUnprotected){
            chain.doFilter(request, response);
        }else{
            request.getRequestDispatcher("WEB-INF/view/loginForm.jsp").forward(request, response);
        }
    }
}
