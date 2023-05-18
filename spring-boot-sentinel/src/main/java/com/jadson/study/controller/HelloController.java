package com.jadson.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dengjunzhen
 * @Date 2023-05-17 15:46
 * @since 1.0
 */
@RestController
public class HelloController {


    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }
}
