package net.coding.apidemo.controller;

import net.coding.apidemo.bean.Message;
import net.coding.apidemo.form.LoginForm;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"会话"})
@RestController
@RequestMapping("/")
public class SessionController {

    @ApiOperation(value = "登录", notes = "用户登录操作")
    @PostMapping("login")
    public ResponseEntity<Message> login(@RequestBody LoginForm form) {
        return ResponseEntity.ok(null);
    }
}
