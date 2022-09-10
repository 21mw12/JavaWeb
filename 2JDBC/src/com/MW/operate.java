package com.MW;

import java.sql.*;

/**
 * 数据库的操作
 */
public class operate {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/school?useUnicode=true&characterEncoding=UTF-8";
        String username = "root";
        String password = "123456";

        try (Connection connection = DriverManager.getConnection(url,username,password);
             Statement statement = connection.createStatement()) {

            /* MDL操作 */
//            int i = statement.executeUpdate("insert into `student` values ('C02090101','何民耀','男','1987-12-24','内蒙古','C020901','010031','内蒙古通辽市玉泉一巷27号','null')");
//            System.out.println("生效了" + i + "行");

//            int i = statement.executeUpdate("delete from `student` where `sno` = 'C02090103'");
//            System.out.println("生效了" + i + "行");

//            int i = statement.executeUpdate("update  `student` set `sname` = '小方' where `sno` = 'C02090101'");
//            System.out.println("生效了" + i + "行");

            /* DQL操作 */
//            ResultSet set = statement.executeQuery("select * from `student`");
//            while (set.next()){
//                System.out.print(set.getString(1));
//                System.out.print(set.getString(2));
//                System.out.print(set.getString(3));
//                System.out.print(set.getString(4));
//                System.out.print(set.getString(5));
//                System.out.println(set.getString(6));
//            }

            /* 批处理操作 */
            //将SQL语句提交到缓存
            statement.addBatch("insert into `student` values ('C02090101','何民耀','男','1987-12-24','内蒙古','C020901','010031','内蒙古通辽市玉泉一巷27号','null')");
            statement.addBatch("insert into `student` values ('C02090104','吕中民','男','1988-06-12','浙江','C020901','321031','浙江省金华市幸福路58号','null')");
            statement.addBatch("insert into `student` values ('C02090103','杨庆云','女','1988-03-02','安徽','C020901','230022','安徽省合肥市桐城路99号','null')");
            //提交SQL语句
            statement.executeBatch();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
