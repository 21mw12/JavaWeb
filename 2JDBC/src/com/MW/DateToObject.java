package com.MW;

import java.lang.reflect.Constructor;
import java.sql.*;
import com.object.Student;

/**
 * 将表内数据映射为对象
 */
public class DateToObject {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/school?useUnicode=true&characterEncoding=UTF-8";
        String username = "root";
        String password = "123456";

        /* 使用一般的方法 */
//        try (Connection connection = DriverManager.getConnection(url,username,password);
//             Statement statement = connection.createStatement()) {
//
//            String sql = "select * from `student`";
//            ResultSet set = statement.executeQuery(sql);
//            while (set.next()){
//                Student student = new Student(set.getString(1),set.getString(2),set.getString(3));
//                student.say();
//            }
//
//        } catch (
//                SQLException throwables) {
//            throwables.printStackTrace();
//        }

        /* 使用反射模糊掉数据类型 */
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            String sql = "select * from `student`";
            ResultSet set = statement.executeQuery(sql);
            while (set.next()) {
                Student student = convert(set, Student.class);
                student.say();
            }

        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static <T> T convert(ResultSet set, Class<T> clazz) {
        try {
            Constructor<T> constructor = clazz.getConstructor(clazz.getConstructors()[0].getParameterTypes());    //默认获得第一个构造方法
            Class<?>[] param = constructor.getParameterTypes();    //获得参数列表
            Object[] object = new Object[param.length];    //存放参数
            for (int i = 0; i < param.length; i++) {
                object[i] = set.getObject(i + 1);
                if (object[i].getClass() != param[i])
                    throw new SQLException("错误的类型转换" + object[i].getClass() + "->" + param[i]);
            }
            return constructor.newInstance(object);
        } catch (ReflectiveOperationException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
