package com.jp.prestamosjava.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class NewDebtForm implements Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "forward:newDebtForm.jsp";
    }
}
