package com.jadson.study.service;

import com.jadson.study.api.HelloService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author dengjunzhen
 * @Date 2023-05-18 14:58
 * @since 1.0
 */
@DubboService
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello0() {
        return "hello world";
    }
}
