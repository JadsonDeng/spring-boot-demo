package com.jadson.study.method2.config;

import com.alibaba.fastjson.JSON;
import com.jadson.study.model.WebSocketMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;

/**
 * websocket的handler，针对不同事件进行处理
 *
 * @author dengjunzhen
 * @date 2023-04-17 17:05
 * @since 1.0
 */
@Component
@Slf4j
public class DefaultWebSocketHandler extends TextWebSocketHandler {


    /**
     * 建立连接
     *
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // 缓存用户信息
        log.info("连接建立成功");
        String token = session.getAttributes().get("token").toString();
        UserSessionHolder.addSession(token, session);
    }


    /**
     * 接收消息
     *
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.info("接收到消息");
        // TODO 每次都需要校验一下token是否有效
        WebSocketMessage value = JSON.parseObject(message.getPayload(), WebSocketMessage.class);
        // 发消息发送给所有在线的用户
        for (Map.Entry<String, WebSocketSession> entry : UserSessionHolder.getAllSession().entrySet()) {
            if (session.getAttributes().get("token").equals(entry.getKey())) {
                // 如果发送者和接受目标是同一个人，则前缀是”我“
                entry.getValue().sendMessage(new TextMessage(("我:" + value.getMessage())));
            } else {
                entry.getValue().sendMessage(new TextMessage("其他人：" + value.getMessage()));
            }
        }
    }

    /**
     * 发生错误
     *
     * @param session
     * @param exception
     * @throws Exception
     */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        // 清除用户缓存信息
        log.info("发生错误", exception);
        String token = session.getAttributes().get("token").toString();
        UserSessionHolder.removeSession(token);
    }


    /**
     * 关闭连接
     *
     * @param session
     * @param closeStatus
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        // 清除用户缓存信息
        log.info("连接断开");
        String token = session.getAttributes().get("token").toString();
        UserSessionHolder.removeSession(token);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
