/*
Navicat MySQL Data Transfer

Source Server         : Jay
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-10-07 18:39:10
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for `tb_area`
-- ----------------------------
DROP TABLE IF EXISTS `tb_area`;
CREATE TABLE `tb_area`
(
    `area_id`        int(2)       NOT NULL AUTO_INCREMENT,
    `area_name`      varchar(200) NOT NULL,
    `priority`       int(2)       NOT NULL DEFAULT '0',
    `create_time`    datetime              DEFAULT NULL,
    `last_edit_time` datetime              DEFAULT NULL,
    PRIMARY KEY (`area_id`),
    UNIQUE KEY `UK_AREA` (`area_name`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of tb_area
-- ----------------------------
INSERT INTO `tb_area`
VALUES ('1', '西苑', '2', '2018-10-06 21:49:27', '2018-10-06 21:49:31');
INSERT INTO `tb_area`
VALUES ('2', '东苑', '1', '2018-10-06 21:49:45', '2018-10-06 21:49:48');
INSERT INTO `tb_area`
VALUES ('3', '南苑', '4', '2018-10-06 21:50:02', '2018-10-06 21:50:05');
INSERT INTO `tb_area`
VALUES ('4', '北苑', '3', '2018-10-06 21:50:18', '2018-10-06 21:50:22');


# consumer 用户
DROP TABLE IF EXISTS `consumer`;
CREATE TABLE `consumer`
(
    `id`            INT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `username`      VARCHAR(20)   DEFAULT NULL,
    `wechat_openid` VARCHAR(50)   DEFAULT NULL,
    `phone`         VARCHAR(20)   DEFAULT NULL,
    `nickname`      VARCHAR(50)   DEFAULT NULL,
    `avatar_url`    VARCHAR(1000) DEFAULT NULL,
    `gender`        VARCHAR(10)   DEFAULT NULL,
    `email`         VARCHAR(100)  DEFAULT NULL,
    `grade`         INT(11)       DEFAULT NULL COMMENT '成绩',
    `deleted`       TINYINT(1)    DEFAULT '0' COMMENT '0:normal 1:deleted',
    `created_by`    BIGINT(20)    DEFAULT NULL,
    `created_at`    BIGINT(20)    DEFAULT NULL,
    `updated_by`    BIGINT(20)    DEFAULT NULL,
    `updated_at`    BIGINT(20)    DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8mb4;


# 题目类型
DROP TABLE IF EXISTS `examtype`;
CREATE TABLE `examtype`
(
    `id`         int(11)                                                 NOT NULL AUTO_INCREMENT,
    `name`       varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
    `createtime` datetime(0)                                             NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

#详细题目类型
DROP TABLE IF EXISTS `examinfo`;
CREATE TABLE `examinfo`
(
    `id`            int(11)                                                  NOT NULL AUTO_INCREMENT COMMENT '业务主键',
    `examtypeid`    int(11)                                                  NULL DEFAULT NULL COMMENT '题目类别ID',
    `name`          varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '名称',
    `a`             varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '答案A',
    `b`             varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '答案B',
    `c`             varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '答案C',
    `d`             varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '答案D',
    `correctanswer` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci   NULL DEFAULT NULL COMMENT '正确答案',
    `explaininfo`   varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '解释',
    `createtime`    datetime(0)                                              NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

# 结果表
DROP TABLE IF EXISTS `answerresult`;
CREATE TABLE `answerresult`
(
    `id`            int(11)                                                NOT NULL AUTO_INCREMENT COMMENT '业务主键',
    `studentid`     int(11)                                                NOT NULL,
    `ssid`          int(11)                                                NULL DEFAULT NULL COMMENT '答题主表ID',
    `examid`        int(11)                                                NULL DEFAULT NULL COMMENT '名称',
    `a`             char(1) CHARACTER SET utf8 COLLATE utf8_general_ci     NULL DEFAULT '0' COMMENT '答案A 0 默认未选中 1 选中',
    `b`             char(1) CHARACTER SET utf8 COLLATE utf8_general_ci     NULL DEFAULT '0' COMMENT '答案B 0 默认未选中 1 选中',
    `c`             char(1) CHARACTER SET utf8 COLLATE utf8_general_ci     NULL DEFAULT '0' COMMENT '答案C 0 默认未选中 1 选中',
    `d`             char(1) CHARACTER SET utf8 COLLATE utf8_general_ci     NULL DEFAULT '0' COMMENT '答案D 0 默认未选中 1 选中',
    `studentanswer` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生答案',
    `correctanswer` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '正确答案',
    `istrue`        char(1) CHARACTER SET utf8 COLLATE utf8_general_ci     NULL DEFAULT '0' COMMENT '答题是否正确0错误，1正确',
    `createtime`    datetime(0)                                            NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `studentsanswer`;
CREATE TABLE `studentsanswer`
(
    `id`         int(11)     NOT NULL AUTO_INCREMENT COMMENT '业务主键',
    `examtypeid` int(11)     NULL DEFAULT NULL COMMENT '题目类别ID',
    `studentid`  int(11)     NULL DEFAULT NULL COMMENT '学生编号',
    `grade`      int(11)     NULL DEFAULT NULL COMMENT '成绩',
    `createtime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

#题目类型
DROP TABLE IF EXISTS `examtype`;
CREATE TABLE `examtype`
(
    `id`   int(11)                                                 NOT NULL AUTO_INCREMENT,
    `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
#                              `createtime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;