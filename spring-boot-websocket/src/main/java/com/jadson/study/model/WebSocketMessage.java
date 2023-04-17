package com.jadson.study.model;

import lombok.Data;

/**
 * websocket发送的消息数据
 * @author dengjunzhen
 * @date 2023-04-17 11:05
 * @since 1.0
 */
@Data
public class WebSocketMessage {

    Integer toUser;
    String message;

}
