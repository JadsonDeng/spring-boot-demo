package com.jadson.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author dengjunzhen
 * @date 2023-03-31 16:28
 * @since 1.0
 */
@SpringBootApplication
public class SaSsoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaSsoServerApplication.class, args);
        System.out.println("\n------ Sa-Token-SSO 认证中心启动成功");
    }
}
