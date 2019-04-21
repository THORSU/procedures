package com.procedures.service;

import com.procedures.pojo.Examtype;

import java.util.List;

public interface ExamtypeService {

    /**
     * 获取所有题目类型
     *
     * @return
     */
    List<Examtype> getExamtype();
}
