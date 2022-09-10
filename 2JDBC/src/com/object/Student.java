package com.object;

public class Student {
    String sno;
    String sname;
    String sex;

    public Student(String sno,String sname,String sex){
        this.sno = sno;
        this.sname = sname;
        this.sex = sex;
    }

    public void say(){
        System.out.println("学号："+sno+"  姓名："+sname+"  性别："+sex);
    }
}
