package com.jp.prestamosjava.action;

import com.jp.prestamosjava.dao.DebtDao;
import com.jp.prestamosjava.model.DebtEntity;
import com.jp.prestamosjava.utils.JPAUtils;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
public class DebtsList implements Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager entityManager = JPAUtils.getEntityManager();
        DebtDao debtDao = new DebtDao(entityManager);
        List<DebtEntity> debtsList = debtDao.debtsList(45);
        request.setAttribute("debts", debtsList);
        return "forward:home.jsp";
    }


}
