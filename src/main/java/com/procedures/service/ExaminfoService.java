package com.procedures.service;

import com.procedures.pojo.Examinfo;

import java.util.List;

public interface ExaminfoService {

    /**
     * 根据题目类型选出题目
     *
     * @param typeId
     * @return
     */
    List<Examinfo> selectList(Integer typeId);
}
