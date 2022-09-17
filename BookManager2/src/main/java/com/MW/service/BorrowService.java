package com.MW.service;

import com.MW.entity.Borrow;

import java.util.List;

public interface BorrowService {

    List<Borrow> getBorrowList();
    void returnBook(String id);
    void addBorrow(int sid, int bid);
}
