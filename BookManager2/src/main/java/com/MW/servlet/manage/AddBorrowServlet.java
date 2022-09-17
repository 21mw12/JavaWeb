package com.MW.servlet.manage;

import com.MW.service.BookService;
import com.MW.service.BorrowService;
import com.MW.service.StudentService;
import com.MW.service.impl.BookServiceImpl;
import com.MW.service.impl.BorrowServiceImpl;
import com.MW.service.impl.StudentServiceImpl;
import com.MW.utils.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;

import java.io.IOException;

@WebServlet("/add-borrow")
public class AddBorrowServlet extends HttpServlet {

    BookService bookService;
    StudentService studentService;
    BorrowService borrowService;
    @Override
    public void init() throws ServletException {
        bookService = new BookServiceImpl();
        studentService = new StudentServiceImpl();
        borrowService = new BorrowServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        context.setVariable("book_list", bookService.getActiveBookList());
        context.setVariable("student_list", studentService.getStudentList());
        ThymeleafUtil.process("add-borrow.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sid = Integer.parseInt(req.getParameter("student"));
        int bid = Integer.parseInt(req.getParameter("book"));
        borrowService.addBorrow(sid, bid);
        resp.sendRedirect("index");
    }
}
