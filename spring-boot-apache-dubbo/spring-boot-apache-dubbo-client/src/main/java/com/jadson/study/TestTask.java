package com.jadson.study;

import com.jadson.study.api.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author dengjunzhen
 * @Date 2023-05-18 15:06
 * @since 1.0
 */
@Component
public class TestTask implements CommandLineRunner {

    @DubboReference
    private HelloService helloService;

    @Override
    public void run(String... args) throws Exception {
        String result = this.helloService.hello0();
        System.out.println(result);
    }
}
