package com.MW.filter;

import com.MW.entity.Admin;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebFilter("/*")
public class MainFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        // 获得请求的路径
        String url = req.getRequestURL().toString();
        // 如果请求的不是static的资源或登录界面，且没有登录，则跳转到登录页面
        if (!url.contains("/static/") && !url.endsWith("login")) {
            HttpSession session = req.getSession();
            Admin admin = (Admin) session.getAttribute("admin");
            if (admin == null) {
                res.sendRedirect("login");
                return;
            }
        }
        // 否则放行
        chain.doFilter(req, res);
    }
}
