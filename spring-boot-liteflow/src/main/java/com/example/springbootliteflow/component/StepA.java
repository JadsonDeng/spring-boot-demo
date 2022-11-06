package com.example.springbootliteflow.component;

import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.slot.DataBus;
import com.yomahub.liteflow.slot.DefaultContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("a")
@Slf4j
public class StepA extends NodeComponent {

    @Override
    public void process() throws Exception {
        Object requestData = this.getRequestData();
        log.info("StepA success...");
    }
}
