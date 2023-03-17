package com.buckwheat.chat.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChatMapper {
	// 채팅방 생성하기
	int insertChattingRoom(Map<String, Object> map);
	
	// 채팅방 불러오기
	List<Map<String, Object>> selectChattingRoomList(Map<String, Object> map);

	// 메세지 보내기
	int insertChattingMsg(Map<String, Object> map);
	
	// 메세지 불러오기
	List<Map<String, Object>> selectChaatingList(Map<String, Object> map);

}
