package com.jadson.study;

import com.jadson.study.rocketmq.RocketmqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class TestController {

    @Autowired
    private RocketmqProducer rocketmqProducer;


    @GetMapping("/sendAsync")
    public String sendAsync(String content) throws Exception {
        this.rocketmqProducer.sendAsync(content);
        return "success";
    }
}
