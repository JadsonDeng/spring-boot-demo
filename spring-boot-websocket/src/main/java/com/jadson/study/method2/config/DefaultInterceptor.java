package com.jadson.study.method2.config;

import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * @author dengjunzhen
 * @date 2023-04-17 17:07
 * @since 1.0
 */
@Component
@Slf4j
public class DefaultInterceptor implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        log.info("开始握手");
        HttpHeaders headers = request.getHeaders();
        List<String> token = headers.get("token");
        if (token == null) {
            // TODO 如果没有session，则需要登录
            return false;
        } else {
            // session有效，把session放入到attribute中
            attributes.put("token", token.get(0));
            return true;
        }
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
        log.info("握手成功");
    }
}
