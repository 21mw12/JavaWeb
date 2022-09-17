package com.MW.mapper;

import com.MW.entity.Borrow;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BorrowMapper {

    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "bid", property = "book_id"),
            @Result(column = "title", property = "book_name"),
            @Result(column = "time", property = "time"),
            @Result(column = "sname", property = "student_name"),
            @Result(column = "sid", property = "student_id")
    })
    @Select("select * from borrow, student, book " +
            "where borrow.sid = student.sid and borrow.bid = book.bid")
    List<Borrow> getBorrowList();

    @Delete("delete from borrow where id = #{id}")
    void deleteBorrow(String id);

    @Insert("insert into borrow(sid, bid, time) values(#{sid}, #{bid}, NOW())")
    void addBorrow(@Param("sid") int sid, @Param("bid") int bid);
}
