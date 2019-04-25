package com.procedures.pojo;


import com.procedures.enums.Gender;
import lombok.Data;

import java.io.Serializable;

@Data
public class Consumer implements Serializable {

    private Long id;
    private String username;
    private String wechatOpenid;
    private Long phone;
    private String nickname;
    private String avatarUrl;
    private Integer grade;
    private Gender gender;
    private String email;
    private Long lastLoginTime;
    private Boolean deleted;
    private Long createdBy;
    private Long createdAt;
    private Long updatedBy;
    private Long updatedAt;

}
