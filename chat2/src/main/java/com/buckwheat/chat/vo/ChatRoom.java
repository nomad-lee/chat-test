package com.buckwheat.chat.vo;

import java.util.*;

import org.springframework.web.socket.WebSocketSession;

import lombok.Data;

@Data
public class ChatRoom {

    private String roomId;
    private Set<WebSocketSession> sessions = new HashSet<>();
    //WebSocketSession은 Spring에서 Websocket Connection이 맺어진 세션

    public static ChatRoom create(){
    	ChatRoom room = new ChatRoom();

        room.roomId = UUID.randomUUID().toString();
        return room;
    }
}