package com.procedures.service;

import com.procedures.pojo.Consumer;
import com.procedures.pojo.WechatAuthCodeResponse;
import com.procedures.pojo.WechatAuthenticationResponse;

public interface WeChatService {

    WechatAuthenticationResponse wechatLogin(String code);

    WechatAuthCodeResponse getWxSession(String code);

    String create3rdSession(String wxOpenId, String wxSessionKey, Long expires);

    void loginOrRegisterConsumer(Consumer consumer);

    void updateConsumerInfo(Consumer consumer);
}
