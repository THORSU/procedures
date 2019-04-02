package com.procedures.controller;

import com.procedures.pojo.AccountDto;
import com.procedures.pojo.Consumer;
import com.procedures.pojo.WechatAuthenticationResponse;
import com.procedures.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {
    @Value("${jwt.header}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private WeChatService weChatService;

    @PostMapping("/auth")
    public ResponseEntity<WechatAuthenticationResponse> createAuthenticationToken(@RequestBody AccountDto accountDto)
            throws AuthenticationException {
        WechatAuthenticationResponse jwtResponse = weChatService.wechatLogin(accountDto.getCode());
        return ResponseEntity.ok(jwtResponse);
    }

    @PostMapping("/updateConsumerInfo")
    public void updateConsumerInfo(@RequestBody Consumer consumer) {
        weChatService.updateConsumerInfo(consumer);
    }
}
