package com.jadson.study;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author dengjunzhen
 * @Date ${YEAR}-${MONTH}-${DAY} ${TIME}
 * @since 1.0
 */
@SpringBootApplication
@EnableDubbo
public class DubboServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboServerApplication.class, args);
    }
}