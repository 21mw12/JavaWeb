package com.MW.service.impl;

import com.MW.entity.Student;
import com.MW.mapper.BookMapper;
import com.MW.mapper.StudentMapper;
import com.MW.service.StudentService;
import com.MW.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> getStudentList() {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            return mapper.getStudenttList();
        }
    }
}
