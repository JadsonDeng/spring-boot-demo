package com.jadson.study.mybatisplus.springbootmybatisplus.controller;

import com.jadson.study.mybatisplus.springbootmybatisplus.mapper.UserMapper;
import com.jadson.study.mybatisplus.springbootmybatisplus.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dengjunzhen
 * @date 2023-03-22 16:16
 * @since 1.0
 */
@RestController
public class UserController {

    @Resource
    private UserMapper userMapper;

    @GetMapping
    public String users() {
        List<User> users = this.userMapper.selectList(null);
        return "success";
    }
}
