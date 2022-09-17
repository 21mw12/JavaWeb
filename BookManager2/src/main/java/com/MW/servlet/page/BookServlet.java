package com.MW.servlet.page;

import com.MW.entity.Admin;
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
import java.util.ArrayList;

@WebServlet("/books")
public class BookServlet extends HttpServlet {

    BookService bookService;
    @Override
    public void init() throws ServletException {
        bookService = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        Admin admin = (Admin) req.getSession().getAttribute("admin");
        context.setVariable("nickname", admin.getNickname());
        context.setVariable("book_list", bookService.getAllBookList().keySet());
        context.setVariable("book_list_state", new ArrayList<>(bookService.getAllBookList().values()));
        ThymeleafUtil.process("books.html", context, resp.getWriter());
    }
}
