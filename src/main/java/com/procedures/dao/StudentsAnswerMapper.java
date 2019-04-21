package com.procedures.dao;

import com.procedures.pojo.Studentsanswer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentsAnswerMapper {

    /**
     * 添加答题主表
     *
     * @param studentsanswer
     */
    void insert(Studentsanswer studentsanswer);
}
