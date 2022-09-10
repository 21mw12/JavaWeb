package com.MW;

import java.sql.*;
import java.util.Scanner;

/**
 * 数据注入问题
 */
public class Injection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/school?useUnicode=true&characterEncoding=UTF-8";
        String username = "root";
        String password = "123456";

        /* SQL注入问题 */
//        try (Connection connection = DriverManager.getConnection(url,username,password);
//             Statement statement = connection.createStatement();
//             Scanner scanner = new Scanner(System.in)) {
//
//            String sql = "select * from `users` where `username` = '"+scanner.nextLine()+"' and `userpwd` = '"+scanner.nextLine()+"';";
//            ResultSet res = statement.executeQuery(sql);
//            while (res.next()) {
//                String uname = res.getString(2);
//                System.out.println(uname+" 登录成功！");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        /* 解决注入问题 */
        String sql = "select * from `users` where `username` = ? and `userpwd` = ?;";
        try (Connection connection = DriverManager.getConnection(url,username,password);
             PreparedStatement statement = connection.prepareStatement(sql);
             Scanner scanner = new Scanner(System.in)) {

            statement.setString(1, scanner.nextLine());
            statement.setString(2, scanner.nextLine());
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                String uname = res.getString(2);
                System.out.println(uname+" 登录成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
