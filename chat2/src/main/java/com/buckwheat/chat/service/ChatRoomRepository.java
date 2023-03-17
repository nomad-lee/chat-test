package com.buckwheat.chat.service;

import java.util.*;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.buckwheat.chat.vo.ChattingRoom;

@Repository
public class ChatRoomRepository {
	private Map<String, ChattingRoom> chattingRoomMap;
	
	// 의존성 주입이 이루어진 후 초기화를 수행
	@PostConstruct
	private void init() {
		chattingRoomMap = new LinkedHashMap<>();
	}
	
	public List<ChattingRoom> findAllRooms(){
		List<ChattingRoom> result = new ArrayList<>(chattingRoomMap.values());
		
		// 가짜 데이터
		ChattingRoom chattingRoom = new ChattingRoom();
		chattingRoom.setChattingRoomNo("1");
		
		result.add(chattingRoom);
		
		Collections.reverse(result); // create_date DESC
		
		return result;
	}
	
	public ChattingRoom findRoomById(String chattingRoomNo) {
		return chattingRoomMap.get(chattingRoomNo);
	}
	
	public ChattingRoom createChatRoom() {

		ChattingRoom room = ChattingRoom.create(); // id, name
		chattingRoomMap.put(room.getChattingRoomNo(), room); // 임시 저장소에 채팅방 추가
		
		return room;
	}
}
