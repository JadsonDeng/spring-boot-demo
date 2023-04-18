package com.jadson.study.method2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.annotation.Resource;

/**
 * websocket配置信息
 *
 * @author dengjunzhen
 * @date 2023-04-17 17:05
 * @since 1.0
 */
@EnableWebSocket
@Configuration
public class WebSocketConfig2 implements WebSocketConfigurer {

    @Resource
    private WebSocketHandler defaultWebSocketHandler;
    @Resource
    private HandshakeInterceptor defaultHandshakeInterceptor;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(this.defaultWebSocketHandler, "/ws") // 添加handler
                .addInterceptors(defaultHandshakeInterceptor) // 添加拦截器
                .setAllowedOrigins("*"); // 允许跨域
    }
}
