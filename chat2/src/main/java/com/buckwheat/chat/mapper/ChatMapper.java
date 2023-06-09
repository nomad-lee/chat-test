package com.buckwheat.chat.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.buckwheat.chat.vo.Chatting;

@Mapper
public interface ChatMapper {
	// 채팅방 생성하기
	int insertChattingRoom();
	
	// 채팅방 불러오기
	List<Map<String, Object>> selectChattingRoomList();
	
	// 메세지 보내기
	int insertChattingMsg(Chatting message);
	
	// 메세지 불러오기
	List<Map<String, Object>> selectChattingList(int chattingRoomNo);

}
