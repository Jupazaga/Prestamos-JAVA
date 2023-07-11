package com.jp.prestamosjava.action;

import com.jp.prestamosjava.dao.DebtDao;
import com.jp.prestamosjava.model.DebtEntity;
import com.jp.prestamosjava.model.UserEntity;
import com.jp.prestamosjava.utils.JPAUtils;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;

public class NewDebt implements Action {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserEntity user = (UserEntity) session.getAttribute("loginUser");
        int debtor = Integer.parseInt(request.getParameter("id"));
        Long amount = (long) Integer.parseInt(request.getParameter("amount"));
        Date lastPayment = Date.valueOf(request.getParameter("lastPayment"));
        DebtEntity debt = new DebtEntity(user.getId(), debtor, lastPayment, amount);

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
        return "redirect:home?action=DebtsList";
    }
}
