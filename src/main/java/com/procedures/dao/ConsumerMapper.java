package com.procedures.dao;

import com.procedures.pojo.Consumer;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ConsumerMapper {

    Consumer findConsumerById(Long id);

    Consumer findConsumerByWechatOpenid(String wechatOpenid);

    void insertConsumer(Consumer consumer);

    void updateConsumer(Consumer consumer);

}
