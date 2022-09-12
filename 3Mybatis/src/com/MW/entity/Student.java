package com.MW.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain=true)
public class Student {
    String sid;
    String name;
    String sex;
    List<Scores> scoresList;
}
