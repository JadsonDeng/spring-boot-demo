package com.jadson.xxljob.springbooxxljob;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

@Component
public class TestJob {

    @XxlJob("testJob")
    public ReturnT<String> testJob(String args) {

        System.out.println("任务开始执行。。。。。。。。。。。。。。。。");
        return ReturnT.SUCCESS;
    }
}
