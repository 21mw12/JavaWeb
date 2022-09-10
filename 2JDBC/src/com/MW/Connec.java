package com.MW;

import java.sql.*;

/**
 * 连接数据库
 */
public class Connec {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/school?useUnicode=true&characterEncoding=UTF-8";
        String username = "root";
        String password = "123456";

        try (//1.通过DriverManager来获得数据库连接
             Connection connection = DriverManager.getConnection(url,username,password);
             //2.创建一个用于执行SQL的Statement对象
             Statement statement = connection.createStatement()) {

            //3.执行SQL语句，并得到结果
            ResultSet set = statement.executeQuery("select * from `student`");
            //4.查看结果
            while (set.next()){
                System.out.print(set.getString(1));
                System.out.println(set.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //5.释放资源，try-with-resource语法会自动使用close
    }
}
