package com.example.springbootliteflow.component;

import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.slot.DefaultContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("c")
@Slf4j
public class StepC extends NodeComponent {

    @Override
    public void process() throws Exception {
        DefaultContext contextBean = this.getContextBean(DefaultContext.class);
        contextBean.setData("response", "process success");
        log.info("StepC success...");
    }
}
