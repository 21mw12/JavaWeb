package com.MW;

import com.MW.util.ConnectMySQL;

public class Main {
    public static void main(String[] args) {

    }

    public static void showStudent() {
        ConnectMySQL.doSqlWork(mapper -> {
            mapper.selectStudent().forEach(student -> {
                System.out.println(student.getSid() + "  " + student.getName() + "  " + student.getSex() + "  " + student.getGrade());
            });
        });
    }

    public static void showBook() {
        ConnectMySQL.doSqlWork(mapper -> {
            mapper.selectBook().forEach(book -> {
                System.out.println(book.getBid() + "  " + book.getTitle() + "  " + book.getDesc() + "  " + book.getPrice());
            });
        });
    }

    public static void showBorrow() {
        ConnectMySQL.doSqlWork(mapper -> {
            mapper.selectBorrow().forEach(borrow -> {
                System.out.println(borrow.getStudent().getName() + " -> " + borrow.getBook().getTitle());
            });
        });
    }
}
