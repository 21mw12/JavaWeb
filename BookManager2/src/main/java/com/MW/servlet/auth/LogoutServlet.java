package com.MW.servlet.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Cookie cookie_adminName = new Cookie("adminName", "username");
//        cookie_adminName.setMaxAge(0);
//        Cookie cookie_adminPassword = new Cookie("adminPassword", "password");
//        cookie_adminPassword.setMaxAge(0);
//        resp.addCookie(cookie_adminName);
//        resp.addCookie(cookie_adminPassword);
//
        req.getSession().removeAttribute("admin");
        resp.sendRedirect("login");
    }
}
