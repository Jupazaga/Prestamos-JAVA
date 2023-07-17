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
import java.util.List;
public class DebtsList implements Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager entityManager = JPAUtils.getEntityManager();
        HttpSession session = request.getSession();
        UserEntity user = (UserEntity) session.getAttribute("loginUser");

        DebtDao debtDao = new DebtDao(entityManager);
        List<DebtEntity> debtsList = debtDao.debtsList(user.getId());
        request.setAttribute("debts", debtsList);
        return "forward:home.jsp";
    }


}
