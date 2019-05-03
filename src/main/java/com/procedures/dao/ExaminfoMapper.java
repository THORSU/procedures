package com.procedures.dao;

import com.procedures.pojo.Examinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExaminfoMapper {
    /**
     * 根据题目类型选出题目
     *
     * @param typeId
     * @return
     */
    List<Examinfo> selectList(@Param("typeId") Integer typeId);

    /**
     * 不按类型选择题目
     *
     * @return
     */
    List<Examinfo> selectExam();
}
