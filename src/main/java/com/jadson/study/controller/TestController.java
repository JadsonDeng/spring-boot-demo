package com.jadson.study.controller;

import com.jadson.study.config.dynamicds.DataSourceContext;
import com.jadson.study.dao.UserDao;
import com.jadson.study.mapper.UserMapper;
import com.jadson.study.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "success";
    }


    // mybatis test
    @Autowired(required = false)
    private UserMapper userMapper;

    @GetMapping("/test/mybatis")
    public List<User> testMyBatis() {
        return userMapper.selectList();
    }

    // 国际化test
    @Autowired
    private ReloadableResourceBundleMessageSource messageSource;

    @GetMapping("/test/hello")
    public String hello(HttpServletRequest request) {
        return messageSource.getMessage("message.001", null, Locale.ENGLISH);
    }


    // 多数据源
    @Autowired
    private UserDao userDao;
    @GetMapping("/test/master")
    public List<User> testMaster() {
        DataSourceContext.setDataSource("master");
        return userDao.selectListReadOnly();
    }

    @GetMapping("/test/slave")
    public List<User> testSlave() {
        DataSourceContext.setDataSource("slave");
        return userDao.selectListReadOnly();
    }

    @GetMapping("/test/default")
    public List<User> testDefault() {
        return userDao.selectListReadOnly();
    }

    // exception测试
    @GetMapping("/test/exception")
    public String testException() {
        int a = 1 / 0;
        return "ok";
    }
}
