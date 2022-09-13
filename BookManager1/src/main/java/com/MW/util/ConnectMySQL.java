package com.MW.util;

import com.MW.mapper.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.function.Consumer;

public class ConnectMySQL {
    //在类加载时就进行创建
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(new FileInputStream("src/main/resources/mybatis-config.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void doSqlWork (Consumer<Mapper> consumer){
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)){
            Mapper Mapper = sqlSession.getMapper(Mapper.class);
            consumer.accept(Mapper);
        }
    }
}
