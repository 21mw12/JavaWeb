package com.MW;

import com.MW.entity.Student;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("A123", "小明", "男");
        System.out.println(student.toString());
    }
}
