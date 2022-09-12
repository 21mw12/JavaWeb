package com.MW;

import com.MW.AnnotationMapper.AnnotationMapper;
import com.MW.entity.Scores;
import com.MW.entity.Student;
import com.MW.mapper.Mapper;
import com.MW.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // true则是开启的事物的自动提交
        try (SqlSession sqlSession = MybatisUtil.getSession(true)){

            Mapper Mapper = sqlSession.getMapper(Mapper.class);
            AnnotationMapper annotationMapper = sqlSession.getMapper(AnnotationMapper.class);

            /* 查询所有成绩信息 */
//            List<Scores> scores = Mapper.selectScores();
//            scores.forEach(System.out::println);

            /* 使用学号查询学生成绩信息 */
//            List<Scores> scores = Mapper.getScoresBySid("A01090101");
//            scores.forEach(System.out::println);

            /* 添加成绩 */
//            Scores scores = new Scores().setSid("A01090101").setCid("A01-00").setGrade(100);
//            System.out.println(Mapper.addScores(scores));

            /* 根据学号和课程号删除学生成绩 */
//            System.out.println(Mapper.deleteScores("A01090101", "A01-00"));

            /* 通过连接表查询，查询学生的信息和成绩 */
//            List<Student> student = Mapper.selectStudent();
//            student.forEach(System.out::println);


            /* 使用注解， 查询所有成绩 */
//            List<Scores> scores = annotationMapper.selectScores();
//            scores.forEach(System.out::println);

            /* 使用注解， 通过学号查询所有成绩 */
//            List<Scores> scores = annotationMapper.getScoresBySid("A01090101");
//            scores.forEach(System.out::println);

            /* 使用注解， 查询所有学生的成绩 */
            List<Student> student = annotationMapper.selectStudent();
            student.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
