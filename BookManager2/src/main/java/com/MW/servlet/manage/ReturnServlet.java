package com.MW.servlet.manage;

import com.MW.service.BorrowService;
import com.MW.service.impl.BorrowServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/return-book")
public class ReturnServlet extends HttpServlet {

    BorrowService service;
    @Override
    public void init() throws ServletException {
        service = new BorrowServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        service.returnBook(id);
        resp.sendRedirect("index");
    }
}
