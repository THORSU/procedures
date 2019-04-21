package com.procedures.dao;

import com.procedures.pojo.Examtype;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExamtypeMapper {

    /**
     * 获取所有题目类型
     *
     * @return
     */
    List<Examtype> getExamtype();
}
