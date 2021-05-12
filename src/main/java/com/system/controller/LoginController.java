package com.system.controller;

import com.system.entity.User;
import com.system.service.IUserService;
import com.util.interceptor.ValidateParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TODO
 * 用户登录
 *
 * @author cxh
 * @date 2021/4/30 11:10
 */
@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    @Autowired
    private IUserService userService;

    // 登录用户 放到redis
    @PostMapping("/login")
    @ValidateParam
    public Object login (@Validated @RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
        return userService.login(user, request, response);
    }

    // 根据token 获取 登入人信息
    @PostMapping("/queryUserInfo")
    public Object queryUserInfo (@RequestBody User user) {
        return userService.queryUserInfo(user);
    }

    // 根据token 获取 删除登录信息
    @PostMapping("/logout")
    public Object delUserInfo (@RequestBody User user,HttpServletResponse response) {
        return userService.delUserInfo(user,response);
    }
}
