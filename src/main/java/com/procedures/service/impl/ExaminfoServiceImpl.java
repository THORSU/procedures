package com.procedures.service.impl;

import com.procedures.dao.ExaminfoMapper;
import com.procedures.pojo.Examinfo;
import com.procedures.service.ExaminfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExaminfoServiceImpl implements ExaminfoService {
    @Resource
    private ExaminfoMapper examinfoMapper;

    @Override
    public List<Examinfo> selectList(Integer typeId) {
        return examinfoMapper.selectList(typeId);
    }
}
