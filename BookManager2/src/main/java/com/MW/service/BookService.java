package com.MW.service;

import com.MW.entity.Book;

import java.util.List;
import java.util.Map;

public interface BookService {

    List<Book> getActiveBookList();
    Map<Book, Boolean> getAllBookList();
    void deleteBook(int bid);
    void addBook(String title, String desc, double price);
}
