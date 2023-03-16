package com.buckwheat.chat.vo;

import lombok.Data;

@Data
public class ChatMsg {
    private String roomId;
    private String writer;
    private String message;
}

