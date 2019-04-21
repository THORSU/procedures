package com.procedures.service.impl;

import com.procedures.dao.ExamtypeMapper;
import com.procedures.pojo.Examtype;
import com.procedures.service.ExamtypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExamtypeServiceImpl implements ExamtypeService {

    @Resource
    private ExamtypeMapper examtypeMapper;

    @Override
    public List<Examtype> getExamtype() {
        return examtypeMapper.getExamtype();
    }
}
