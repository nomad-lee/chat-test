package com.buckwheat.chat.vo;

import java.util.UUID;

import lombok.Data;

@Data
public class ChattingRoom {
	private String chattingRoomNo; // roomId
	private String createdate;
	private String updatedate;
	
    public static ChattingRoom create(){
    	ChattingRoom room = new ChattingRoom();

        room.chattingRoomNo = UUID.randomUUID().toString();
        return room;
    }
}
