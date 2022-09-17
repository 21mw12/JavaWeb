package com.MW.service.impl;


import com.MW.entity.Book;
import com.MW.entity.Borrow;
import com.MW.mapper.BookMapper;
import com.MW.mapper.BorrowMapper;
import com.MW.service.BookService;
import com.MW.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.*;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService {

    @Override
    public List<Book> getActiveBookList() {
        BorrowServiceImpl borrowService = new BorrowServiceImpl();
        Set<Integer> set = new HashSet<>();
        borrowService.getBorrowList().forEach(borrow -> set.add(borrow.getBook_id()));
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
            return mapper.getBookList()
                        .stream()
                        .filter(book -> !set.contains(book.getBid()))
                        .collect(Collectors.toList());
        }
    }

    @Override
    public Map<Book, Boolean> getAllBookList() {
        BorrowServiceImpl borrowService = new BorrowServiceImpl();
        Set<Integer> set = new HashSet<>();
        borrowService.getBorrowList().forEach(borrow -> set.add(borrow.getBook_id()));
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            Map<Book, Boolean> map = new LinkedHashMap<>();
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
            mapper.getBookList().forEach(book -> map.put(book , set.contains(book.getBid())));
            return map;
        }
    }

    @Override
    public void deleteBook(int bid) {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
            mapper.deleteBook(bid);
        }
    }

    @Override
    public void addBook(String title, String desc, double price) {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
            mapper.addBook(title, desc, price);
        }
    }
}
