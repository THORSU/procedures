package com.procedures.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Studentsanswer implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 业务主键
     */

    private Integer id;
    /**
     * 题目类别ID
     */

    private Integer examtypeid;


    private String examinfoname;
    /**
     * 成绩
     */
    private Integer grade;
    private Integer studentid;
    /**
     * 创建时间
     */
    private Date createtime;
}
