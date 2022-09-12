package com.MW.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class Scores {
    String sid;
    String cid;
    double grade;
}
