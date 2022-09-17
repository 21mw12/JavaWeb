package com.MW.service.impl;

import com.MW.entity.Admin;
import com.MW.mapper.AdminMapper;
import com.MW.service.AdminService;
import com.MW.utils.MybatisUtil;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;

public class AdminServiceImpl implements AdminService {

    @Override
    public boolean auth(String username, String password, HttpSession session) {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
            Admin admin = mapper.getAdmin(username, password);
            if (admin == null) return false;
            session.setAttribute("admin", admin);
            return true;
        }
    }
}
