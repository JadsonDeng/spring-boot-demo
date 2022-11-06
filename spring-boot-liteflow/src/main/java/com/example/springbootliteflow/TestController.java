package com.example.springbootliteflow;

import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import com.yomahub.liteflow.slot.DefaultContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class TestController {

    @Resource
    private FlowExecutor flowExecutor;

    @GetMapping("/test")
    public String test() {
        log.info("aaa {}", flowExecutor);
        LiteflowResponse response = flowExecutor.execute2Resp("chain1", "param");
        Object response1 = response.getContextBean(DefaultContext.class).getData("response");
        return "success";
    }
}
