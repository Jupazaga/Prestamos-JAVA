package com.jp.prestamosjava.action;

import com.jp.prestamosjava.dao.UserDao;
import com.jp.prestamosjava.model.UserEntity;
import com.jp.prestamosjava.utils.JPAUtils;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
public class Login implements Action{

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userField = request.getParameter("user");
        String passwordField = request.getParameter("password");
        UserEntity user;
        try {
            EntityManager entityManager = JPAUtils.getEntityManager();
            UserDao userDao = new UserDao(entityManager);
            user = userDao.findUser(userField, passwordField);
            System.out.println(user.getName());
        } catch (Exception exception) {
            System.out.println("Usuario o contraseña incorrectos");
            return "redirect:home?action=LoginForm";
        }
        HttpSession session = request.getSession();
        session.setAttribute("loginUser", user);
        return "redirect:home?action=DebtsList";
    }
}
