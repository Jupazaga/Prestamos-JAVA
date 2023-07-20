package com.jp.prestamosjava.servlet;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

import com.jp.prestamosjava.action.Action;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet(urlPatterns = "home")
public class ControllerFilter implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String actionParameter = request.getParameter("action");
        System.out.println("Action Controller: " + actionParameter);
        String className = "com.jp.prestamosjava.action." + actionParameter;

        Class<?> clazz;
        String page = null;
        try {
            clazz = Class.forName(className);
            Object object = clazz.getDeclaredConstructor().newInstance();
            Action action = (Action) object;
            page = action.execute(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            System.out.println("Page Not Found");
            request.getRequestDispatcher("WEB-INF/view/home.jsp").forward(request, response);
        }
        if (page != null){
            String[] typeAndDirection = page.split(":");
            if (typeAndDirection[0].equals("forward")){
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/" + typeAndDirection[1]);
                requestDispatcher.forward(request, response);
            }else {
                response.sendRedirect(typeAndDirection[1]);
            }
        }
    }
}