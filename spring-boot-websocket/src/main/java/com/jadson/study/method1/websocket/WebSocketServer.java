//package com.jadson.study.websocket;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.jadson.study.model.WebSocketMessage;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//import javax.websocket.*;
//import javax.websocket.server.ServerEndpoint;
//import java.io.IOException;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
///**
// * 处理websocket的接口。
// * <p>
// * 注意：每一个客户端连接后，都会创建一个新的WebSocketServer实例，也就是说它是多例
// * </p>
// *
// * @author dengjunzhen
// * @date 2023-04-17 11:08
// * @since 1.0
// */
//@ServerEndpoint("/chat")
//@Component
//@Slf4j
//public class WebSocketServer {
//
//
//    // session集合,存放对应的session
//    private static ConcurrentHashMap<Integer, Session> sessionPool = new ConcurrentHashMap<>();
//
//
//    /**
//     * 建立WebSocket连接
//     *
//     * @param session
//     */
//    @OnOpen
//    public void onOpen(Session session) {
//        int userId = this.getUserIdFromSession(session);
//        log.info("WebSocket建立连接中,连接用户ID：{}", userId);
//        sessionPool.put(userId, session);
//        log.info("建立连接完成,当前在线人数为：{}", sessionPool.size());
//    }
//
//    /**
//     * 发生错误
//     *
//     * @param throwable e
//     */
//    @OnError
//    public void onError(Throwable throwable) {
//        throwable.printStackTrace();
//    }
//
//    /**
//     * 连接关闭
//     */
//    @OnClose
//    public void onClose(Session session) {
//        sessionPool.remove(this.getUserIdFromSession(session));
//        log.info("连接断开,当前在线人数为：{}", sessionPool.size());
//    }
//
//    /**
//     * 接收客户端消息
//     *
//     * @param message 接收的消息
//     */
//    @OnMessage
//    public void onMessage(Session session, String message) throws Exception {
//        log.info("收到客户端发来的消息：{}", message);
//        this.sendAllMessage(session, message);
//
//    }
//
//
//    /**
//     * 推送消息到指定用户
//     *
//     * @param userId  用户ID
//     * @param message 发送的消息
//     */
//    public void sendMessageByUser(Integer userId, String message) {
//        log.info("用户ID：" + userId + ",推送内容：" + message);
//        Session session = sessionPool.get(userId);
//        try {
//            session.getBasicRemote().sendText(message);
//        } catch (IOException e) {
//            log.error("推送消息到指定用户发生错误：" + e.getMessage(), e);
//        }
//    }
//
//    /**
//     * 群发消息
//     *
//     * @param message 发送的消息
//     */
//    public void sendAllMessage(Session session, String message) throws IOException {
//        log.info("发送消息：{}", message);
//        int userId = this.getUserIdFromSession(session);
//
//        // 发消息发送给所有在线的用户
//        WebSocketMessage value = JSONObject.toJavaObject(JSON.parseObject(message), WebSocketMessage.class);
//        for (Map.Entry<Integer, Session> entry : sessionPool.entrySet()) {
//            if (userId == entry.getKey()) {
//                // 如果发送者和接受目标是同一个人，则前缀是”我“
//                entry.getValue().getBasicRemote().sendText("我:" + value.getMessage());
//            } else {
//                entry.getValue().getBasicRemote().sendText(userId + ":" + value.getMessage());
//            }
//        }
//    }
//
//    private int getUserIdFromSession(Session session) {
//        Map<String, List<String>> map = session.getRequestParameterMap();
//        List<String> userId = map.get("userId");
//        return Integer.parseInt(userId.get(0));
//    }
//}
