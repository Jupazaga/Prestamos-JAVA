package com.jp.prestamosjava.action;

import com.jp.prestamosjava.dao.DebtDao;
import com.jp.prestamosjava.model.DebtEntity;
import com.jp.prestamosjava.utils.JPAUtils;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;

@WebServlet(urlPatterns = "/NewDebt")
public class NewDebt extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        int lender = 45;
        int debtor = Integer.parseInt(request.getParameter("id"));
        Long amount = (long) Integer.parseInt(request.getParameter("amount"));
        Date lastPayment = Date.valueOf(request.getParameter("lastPayment"));
        DebtEntity debt = new DebtEntity(lender, debtor, lastPayment, amount);

        EntityManager entityManager = JPAUtils.getEntityManager();
        DebtDao debtDao = new DebtDao(entityManager);
        try{
            entityManager.getTransaction().begin();
            debtDao.save(debt);
            entityManager.getTransaction().commit();
        }catch (Exception exception){
            System.out.println("An exception happened in the transaction");
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }

    }
}
