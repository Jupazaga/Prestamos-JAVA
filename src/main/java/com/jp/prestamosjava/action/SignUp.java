package com.jp.prestamosjava.action;

import com.jp.prestamosjava.dao.UserDao;
import com.jp.prestamosjava.model.UserEntity;
import com.jp.prestamosjava.utils.JPAUtils;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SignUp implements Action {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String user = request.getParameter("user");
        String password = request.getParameter("password");

        UserEntity userEntity = new UserEntity( id ,name, user, password);
        EntityManager entityManager = JPAUtils.getEntityManager();
        try{
            UserDao userDao = new UserDao(entityManager);
            entityManager.getTransaction().begin();
            userDao.save(userEntity);
            entityManager.getTransaction().commit();
        }catch (Exception exception){
            System.out.println("Error en la transaccion");
            System.out.println(exception.getMessage());
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
        return "forward:newDebtForm.jsp";
    }
}
