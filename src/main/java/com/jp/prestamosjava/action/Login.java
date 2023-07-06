package com.jp.prestamosjava.action;

import com.jp.prestamosjava.dao.UserDao;
import com.jp.prestamosjava.model.UserEntity;
import com.jp.prestamosjava.utils.JPAUtils;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(urlPatterns = "/Login")
public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userField = request.getParameter("user");
        String passwordField = request.getParameter("password");
        try{
            EntityManager entityManager = JPAUtils.getEntityManager();
            UserDao userDao = new UserDao(entityManager);
            UserEntity user = userDao.findUser(userField, passwordField);
            System.out.println(user.getName());
        }catch (Exception exception){
            System.out.println("Usuario o contraseña incorrectos");
            request.getRequestDispatcher("WEB-INF/View/loginForm.jsp").forward(request, response);
        }

    }
}
