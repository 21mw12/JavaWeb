package com.MW.mapper;

import com.MW.entity.Book;
import com.MW.entity.Borrow;
import com.MW.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface Mapper {
    @Results({
            @Result(column = "sname", property = "name")
    })
    @Select("select * from student")
    List<Student> selectStudent();

    @Results({
            @Result(column = "sname", property = "name")
    })
    @Select("select * from student where sid = #{sid}")
    List<Student> selectStudentById(int sid);

    @Select("select * from book")
    List<Book> selectBook();

    @Select("select * from book where bid = #{bid}")
    List<Book> selectBookById(int bid);

    @Results({
            @Result(column = "id", property = "id", id = true),
            @Result(column = "sid",property = "student", one = @One(select = "selectStudentById")),
            @Result(column = "bid",property = "book",  one = @One(select = "selectBookById"))
    })
    @Select("select * from borrow")
    List<Borrow> selectBorrow();

    @Insert("insert into student value (#{sid}, #{name}, #{sex}, #{grade})")
    int InsStudent(Student student);

    @Delete("delete from student where sid = #{sid}")
    int DelStudent(int sid);

    @Insert("insert into book value (#{title}, #{desc}, #{price})")
    int InsBook(Book book);

    @Delete("delete from book where bid = #{bid}")
    int DelBook(int bid);
}
