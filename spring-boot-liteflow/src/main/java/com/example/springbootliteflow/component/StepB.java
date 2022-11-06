package com.example.springbootliteflow.component;

import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("b")
@Slf4j
public class StepB extends NodeComponent {

    @Override
    public void process() throws Exception {
        log.info("StepB success...");
    }
}
