package com.MW.servlet.auth;

import com.MW.service.AdminService;
import com.MW.service.impl.AdminServiceImpl;
import com.MW.utils.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    AdminService service;

    @Override
    public void init() throws ServletException {
        Context context = new Context();
        context.setVariable("failure", true);
        service = new AdminServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            String admineName = null;
            String adminPassword = null;
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("admineName")) admineName = cookie.getValue();
                if (cookie.getName().equals("adminPassword")) adminPassword = cookie.getValue();
            }
            if (admineName != null && adminPassword != null) {
                if (service.auth(admineName, adminPassword, req.getSession())) {
                    resp.sendRedirect("index");
                    return;
                }
            }
        }

        Context context = new Context();
        if (req.getSession().getAttribute("login-failure") != null) {
            context.setVariable("failure", true);
            req.getSession().removeAttribute("login-failure");
        }
        if (req.getSession().getAttribute("admin") != null) {
            resp.sendRedirect("index");
            return;
        }
        ThymeleafUtil.process("login.html", context, resp.getWriter());
    }

    /* 点击登录后发出的post请求在这里响应 */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remeber = req.getParameter("remeber-me");
        if (service.auth(username, password, req.getSession())) {
            if (remeber != null) {
                Cookie cookie_adminName = new Cookie("adminName", username);
                cookie_adminName.setMaxAge(60 * 60 * 24 * 7);
                Cookie cookie_adminPassword = new Cookie("adminPassword", password);
                cookie_adminPassword.setMaxAge(60 * 60 * 24 * 7);
                resp.addCookie(cookie_adminName);
                resp.addCookie(cookie_adminPassword);
            }
            resp.sendRedirect("index");
        } else {
            req.getSession().setAttribute("login-failure", new Object());
            this.doGet(req, resp);
        }
    }
}
