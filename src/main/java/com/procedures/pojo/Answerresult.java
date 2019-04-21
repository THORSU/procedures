package com.procedures.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data

public class Answerresult implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 业务主键
     */

    private Integer id;
    /**
     *
     */
    private Integer studentid;
    /**
     * 学员答题主表ID
     */
    private Integer ssid;
    /**
     * 题目id
     */
    private Integer examid;
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
     * 学生答案
     */
    private String studentanswer;
    /**
     * 正确答案
     */
    private String correctanswer;

    /**
     * 答题是否正确0错误，1正确
     */
    private String istrue;
    /**
     * 创建时间
     */
    private Date createtime;


    private String examname;

    private String exama;

    private String examb;

    private String examc;

    private String examd;

    private String examcorrectanswer;

    private String examexplaininfo;
}
