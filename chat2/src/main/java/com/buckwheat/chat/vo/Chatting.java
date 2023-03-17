package com.buckwheat.chat.vo;

import lombok.Data;

@Data
public class Chatting {
	private String chattingNo; // 임시로 String
	private String chattingRoomNo; // 임시로 String roomId
	private String fromId; // writer
	private String toId;
	private String chattingMemo; // message
	private String createdate;
}
