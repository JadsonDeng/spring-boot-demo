package com.jadson.study.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultLitePullConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.jadson.study.Constants.*;

@Service
@Slf4j
public class RocketmqConsumer {

    private DefaultLitePullConsumer consumer = null;

    @PostConstruct
    public void init() {
        new Thread(() -> {
            consumer = new DefaultLitePullConsumer();
            try {
                consumer.setPullBatchSize(1000);
                consumer.setNamesrvAddr(ROCKET_MQ_NAMESRV);
                consumer.setConsumerGroup(GROUP_NAME);
                consumer.subscribe(TOPIC, "*");
                consumer.start();

                System.out.println("消费者启动成功...");
                while (true) {
                    if (!consumer.isRunning()) {
                        log.info("消费者停止");
                        return;
                    }
                    List<MessageExt> list = consumer.poll(1000L);
                    if (list == null || list.size() == 0) {
                        continue;
                    }
                    for (MessageExt message : list) {
                        log.info("消费到数据：" + new String(message.getBody(), StandardCharsets.UTF_8));
                        log.info("topic: " + message.getTopic());
                        log.info("tags: " + message.getTags());
                        log.info("queId: " + message.getQueueId());
                        log.info("offset: " + message.getQueueOffset());
                    }
                }
            } catch (Exception e) {
                log.info("消费数据发生异常，", e);
            } finally {
                consumer.shutdown();
                log.info("消费者关闭成功...");
            }
        }).start();

    }

    @PreDestroy
    public void destroy() {
        if (consumer != null) {
            consumer.shutdown();
        }
        log.info("消费者关闭成功");
    }

}
