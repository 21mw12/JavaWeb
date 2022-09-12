package com.MW.AnnotationMapper;


import com.MW.entity.Scores;
import com.MW.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 使用注解开发
 * 避免了一个接口对应一个xml文件的繁琐
 * 在大多数情况下注解足以满足需求
 */
public interface AnnotationMapper {
    @Results({
            @Result(id = true, column = "sno", property = "sid"),
            @Result(column = "cno", property = "cid"),
            @Result(column = "sex", property = "sex")
    })
    @Select("select * from scores")
    List<Scores> selectScores();

    @Results({
            @Result(id = true, column = "sno", property = "sid"),
            @Result(column = "cno", property = "cid"),
            @Result(column = "sex", property = "sex")
    })
    @Select("select * from scores where sno = #{sid}")
    List<Scores> getScoresBySid(String sid);

    @Results({
            @Result(id = true, column = "sno", property = "sid"),
            @Result(column = "sname", property = "name"),
            @Result(column = "sex", property = "sex"),

            @Result(column = "sno", property = "scoresList", many =
                @Many(select = "getScoresBySid")
            )
    })
    @Select("select sno,sname,sex from student\n")
    List<Student> selectStudent();
}
