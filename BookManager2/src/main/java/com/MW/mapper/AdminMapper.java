package com.MW.mapper;

import com.MW.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AdminMapper {

    @Select("select * from admin where username = #{username} and password = #{password}")
    Admin getAdmin(@Param("username") String username, @Param("password") String password);
}
