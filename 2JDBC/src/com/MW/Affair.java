package com.MW;

import java.sql.*;

public class Affair {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/school?useUnicode=true&characterEncoding=UTF-8";
        String username = "root";
        String password = "123456";

        try (Connection connection = DriverManager.getConnection(url,username,password);
             Statement statement = connection.createStatement()) {

            connection.setAutoCommit(false);    //  关闭自动提交后相当于开启事务

            statement.addBatch("insert into `student` values ('C02090101','何民耀','男','1987-12-24','内蒙古','C020901','010031','内蒙古通辽市玉泉一巷27号','null')");
            statement.addBatch("insert into `student` values ('C02090104','吕中民','男','1988-06-12','浙江','C020901','321031','浙江省金华市幸福路58号','null')");
            statement.addBatch("insert into `student` values ('C02090103','杨庆云','女','1988-03-02','安徽','C020901','230022','安徽省合肥市桐城路99号','null')");
            statement.executeBatch();

            Savepoint savepoint = connection.setSavepoint();    // 设置回滚点

            int i = statement.executeUpdate("delete from `student` where `sno` = 'C02090103'");
            System.out.println("生效了" + i + "行");

            connection.commit();	//  事务提交
            //connection.rollback(savepoint);	//  事务回滚

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
