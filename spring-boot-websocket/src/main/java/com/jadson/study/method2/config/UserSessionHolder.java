package com.jadson.study.method2.config;

import org.springframework.web.socket.WebSocketSession;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author dengjunzhen
 * @date 2023-04-17 17:33
 * @since 1.0
 */
public class UserSessionHolder {

    private static Map<String, WebSocketSession> map = new ConcurrentHashMap<>();

    public static void addSession(String token, WebSocketSession session) {
        map.put(token, session);
    }

    public static void removeSession(String token) {
        map.remove(token);
    }

    public static WebSocketSession getSession(String token) {
        return map.get(token);
    }

    public static Map<String, WebSocketSession> getAllSession() {
        return map;
    }
}
