package com.jadson.study.method2.config;

import org.springframework.web.socket.WebSocketSession;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 保存每个用户的会话
 *
 * @author dengjunzhen
 * @date 2023-04-17 17:33
 * @since 1.0
 */
public class UserSessionHolder {

    /**
     * 保存每个用户的绘画
     */
    private static Map<String, WebSocketSession> map = new ConcurrentHashMap<>();


    /**
     * 新增会话
     *
     * @param token
     * @param session
     */
    public static void addSession(String token, WebSocketSession session) {
        map.put(token, session);
    }

    /**
     * 删除会话
     *
     * @param token
     */
    public static void removeSession(String token) {
        map.remove(token);
    }

    /**
     * 获取指定用户的会话
     *
     * @param token
     * @return
     */
    public static WebSocketSession getSession(String token) {
        return map.get(token);
    }

    /**
     * 获取全部会话
     *
     * @return
     */
    public static Map<String, WebSocketSession> getAllSession() {
        return map;
    }
}
