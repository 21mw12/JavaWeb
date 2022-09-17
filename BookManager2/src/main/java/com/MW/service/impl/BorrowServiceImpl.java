package com.MW.service.impl;

import com.MW.entity.Borrow;
import com.MW.mapper.BorrowMapper;
import com.MW.service.BorrowService;
import com.MW.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BorrowServiceImpl implements BorrowService {

    @Override
    public List<Borrow> getBorrowList() {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            BorrowMapper mapper = sqlSession.getMapper(BorrowMapper.class);
            return mapper.getBorrowList();
        }
    }

    @Override
    public void returnBook(String id) {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            BorrowMapper mapper = sqlSession.getMapper(BorrowMapper.class);
            mapper.deleteBorrow(id);
        }
    }

    @Override
    public void addBorrow(int sid, int bid) {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            BorrowMapper mapper = sqlSession.getMapper(BorrowMapper.class);
            mapper.addBorrow(sid, bid);
        }
    }
}
