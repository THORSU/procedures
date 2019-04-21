package com.procedures.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

//题目类型
@Data
@TableName("examtype")
public class Examtype implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 创建时间
     */
    private Date createtime;
}
