package com.MW.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Borrow {
    int id;
    Student student;
    Book book;
}
