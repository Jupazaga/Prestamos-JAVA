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
import java.util.List;
@WebServlet(urlPatterns = "/DebtsList")
public class DebtsList extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager entityManager = JPAUtils.getEntityManager();
        DebtDao debtDao = new DebtDao(entityManager);
        List<DebtEntity> debtsList = debtDao.debtsList(45);
        request.setAttribute("debts", debtsList);
        request.getRequestDispatcher("WEB-INF/View/home.jsp").forward(request, response);
    }
}
