package com.MW.mapper;

import com.MW.entity.Student;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {

    @Results({
            @Result(column = "sid", property = "sid"),
            @Result(column = "sname", property = "name"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "grade", property = "grade")
    })
    @Select("select * from student")
    List<Student> getStudenttList();
}
