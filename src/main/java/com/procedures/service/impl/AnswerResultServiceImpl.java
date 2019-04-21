package com.procedures.service.impl;

import com.procedures.dao.AnswerResultMapper;
import com.procedures.pojo.Answerresult;
import com.procedures.service.AnswerResultService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AnswerResultServiceImpl implements AnswerResultService {

    @Resource
    private AnswerResultMapper answerResultMapper;

    @Override
    public void insert(Answerresult answerresult) {
        answerResultMapper.insert(answerresult);
    }
}
