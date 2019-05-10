package com.procedures.service.impl;

import com.procedures.dao.AnswerResultMapper;
import com.procedures.pojo.Answerresult;
import com.procedures.pojo.Studentsanswer;
import com.procedures.service.AnswerResultService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

@Service
public class AnswerResultServiceImpl implements AnswerResultService {

    @Resource
    private AnswerResultMapper answerResultMapper;

    @Override
    public void insert(Answerresult answerresult) {
        answerResultMapper.insert(answerresult);
    }

    @Override
    public Studentsanswer getAnswer(String studentid) {
        return answerResultMapper.getAnswer(studentid);
    }

    @Override
    public Integer addGrade(Studentsanswer studentsanswer) {
        return answerResultMapper.addGrade(studentsanswer);
    }

    @Override
    public Integer updateGrade(Studentsanswer studentsanswer) {
        return answerResultMapper.updateGrade(studentsanswer);
    }

    @Override
    public Set<String> getTopGrade() {
        return answerResultMapper.getTopGrade();
    }
}
