package com.procedures.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

//题目
@Data
public class Examinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 业务主键
     */
    private Integer id;
    /**
     * 题目类别ID
     */
    private Integer examtypeid;
    /**
     * 题目名
     */
    private String examtypename;
    /**
     * 名称
     */
    private String name;
    /**
     * 答案A
     */
    private String a;
    /**
     * 答案B
     */
    private String b;
    /**
     * 答案C
     */
    private String c;
    /**
     * 答案D
     */
    private String d;
    /**
     * 正确答案
     */
    private String correctanswer;
    /**
     * 解释
     */
    private String explaininfo;
    /**
     * 创建时间
     */
    private Date createtime;
}
