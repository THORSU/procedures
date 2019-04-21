package com.procedures.pojo;

import lombok.Data;

import java.io.Serializable;

//题目类型
@Data
public class Examtype implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
}
