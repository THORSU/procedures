package com.procedures.service;

import com.procedures.pojo.Answerresult;
import com.procedures.pojo.Studentsanswer;

import java.util.Set;

public interface AnswerResultService {

    /**
     * 添加答题结果
     *
     * @param answerresult
     */
    void insert(Answerresult answerresult);

    /**
     * 查看成绩表是否有该人记录
     *
     * @param studentid
     * @return
     */
    Studentsanswer getAnswer(String studentid);

    /**
     * 插入成绩新纪录
     *
     * @param studentsanswer
     * @return
     */
    Integer addGrade(Studentsanswer studentsanswer);

    /**
     * 更新成绩
     *
     * @param studentsanswer
     * @return
     */
    Integer updateGrade(Studentsanswer studentsanswer);

    /**
     * 获得前10名用户成绩
     *
     * @return
     */
    Set<String> getTopGrade();
}
