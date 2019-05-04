package com.procedures.controller;

import com.alibaba.fastjson.JSON;
import com.procedures.pojo.AccountDto;
import com.procedures.pojo.Consumer;
import com.procedures.pojo.WechatAuthenticationResponse;
import com.procedures.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthController {
    @Value("${jwt.header}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private WeChatService weChatService;

    //授权接口
    @PostMapping("/auth")
    public ResponseEntity<WechatAuthenticationResponse> createAuthenticationToken(@RequestBody AccountDto accountDto)
            throws AuthenticationException {
        WechatAuthenticationResponse jwtResponse = weChatService.wechatLogin(accountDto.getCode());
        return ResponseEntity.ok(jwtResponse);
    }

    //更新用户表
    @PostMapping("/updateConsumerInfo")
    public void updateConsumerInfo(@RequestBody Consumer consumer) {
        weChatService.updateConsumerInfo(consumer);
    }

    //获得用户信息
    @GetMapping("/getConsumerInfo")
    public Object getConsumerInfo() {
        return JSON.toJSONString(weChatService.getConsumerInfo());
    }
}
