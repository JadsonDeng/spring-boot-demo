package com.jadson.study.controller;

import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dengjunzhen@hualala.com
 * @date 2023-03-06 14:48
 * @since 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public String login(String username, String password) {
        if ("dengjunzhen".equals(username) && "password".equals(password)) {
            StpUtil.login(10001);
            return "登录成功";
        }
        return "登录失败";
    }


    @GetMapping("/logout")
    public String logout() {
        StpUtil.logout();
        return "success";
    }

    @GetMapping("/isLogin")
    public String isLogin() {
        boolean login = StpUtil.isLogin();
        return "登录状态:" + login;
    }

}
