package com.procedures.dao;

import com.procedures.pojo.Answerresult;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AnswerResultMapper {
    /**
     * 添加答题结果
     *
     * @param answerresult
     */
    void insert(Answerresult answerresult);
}
