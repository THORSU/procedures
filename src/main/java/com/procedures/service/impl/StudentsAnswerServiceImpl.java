package com.procedures.service.impl;

import com.procedures.dao.StudentsAnswerMapper;
import com.procedures.pojo.Studentsanswer;
import com.procedures.service.StudentsAnswerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("StudentsAnswerService")
public class StudentsAnswerServiceImpl implements StudentsAnswerService {
    @Resource
    private StudentsAnswerMapper studentsAnswerMapper;

    @Override
    public void insert(Studentsanswer studentsanswer) {
        studentsAnswerMapper.insert(studentsanswer);
    }
}
