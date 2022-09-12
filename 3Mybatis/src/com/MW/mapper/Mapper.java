package com.MW.mapper;

import com.MW.entity.Student;
import com.MW.entity.Scores;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 映射器的接口
 * 通过动态代理生成，相当于动态的生成了一个实现类
 */
public interface Mapper {
    List<Scores> selectScores();
    List<Scores> getScoresBySid(String sid);
    int addScores(Scores scores);
    int deleteScores(@Param("sid") String sid, @Param("cid") String cid);

    List<Student> selectStudent();
}
