package com.jp.prestamosjava.servlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "home", value = "/home")
public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        try {
            request.getRequestDispatcher("/DebtsList").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

    }
}