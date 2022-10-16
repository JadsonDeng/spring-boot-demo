package com.jadson.study.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import java.nio.charset.StandardCharsets;

import static com.jadson.study.Constants.*;

/**
 * rocketmq生产者示例，这里仅仅是用来测试，实际与springboot无关
 */
@Service
@Slf4j
public class RocketmqProducer {

    private DefaultMQProducer producer;


    @PostConstruct
    public void init() throws Exception {
        producer = new DefaultMQProducer(GROUP_NAME);
        producer.setNamesrvAddr(ROCKET_MQ_NAMESRV);
        producer.start();
        log.info("生产者对象创建成功...");
    }

    public void sendAsync(String content) throws Exception {
        Message message = new Message();
        message.setTopic(TOPIC);
        message.setBody(content.getBytes(StandardCharsets.UTF_8));
        message.setTags("tag");
        this.producer.send(message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("消息发送成功：" + sendResult);
            }

            @Override
            public void onException(Throwable throwable) {
                log.info("消息发送失败：" + throwable);
            }
        });
    }

    @PreDestroy
    public void destroy() {
        if (producer != null) {
            producer.shutdown();
        }
        log.info("生产者对象销毁。。。");
    }
}
