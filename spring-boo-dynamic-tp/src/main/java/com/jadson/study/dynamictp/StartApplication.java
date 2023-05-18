package com.jadson.study.dynamictp;

import org.dromara.dynamictp.core.spring.EnableDynamicTp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author dengjunzhen
 * @Date 2023-05-15 17:06
 * @since 1.0
 */
@SpringBootApplication
@EnableDynamicTp
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}
