package com.example.pandu.controller;

import com.example.pandu.common.JsonOk;
import com.example.pandu.model.persist.param.systemuser.SystemUserLoginParam;
import com.example.pandu.model.persist.param.systemuser.SystemUserRegisterParam;
import com.example.pandu.service.impl.SystemUserServiceImpl;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    @Resource
    private SystemUserServiceImpl systemUserServiceImpl;


    // 用户登录操作
    @PostMapping("/systemlogin")
    public JsonOk login(@RequestBody SystemUserLoginParam systemUserLoginParam, HttpServletRequest request) {
        return JsonOk.success("登录成功",systemUserServiceImpl.login(systemUserLoginParam.getPhone(), systemUserLoginParam.getPassword(),
                request.getRemoteAddr(),
                request.getHeader("User-Agent"))
        );
    }


    // 注册操作
    @PostMapping("/register")
    public JsonOk register(@RequestBody SystemUserRegisterParam systemUserRegisterParam, HttpServletRequest request) {
        systemUserServiceImpl.register(systemUserRegisterParam,request.getRemoteAddr());
        return JsonOk.success("注册成功");
    }

}
