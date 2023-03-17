/*
package com.buckwheat.chat.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buckwheat.chat.vo.ChatRoom;

@Service
@Transactional
public class ChatService {
	@Autowired
	//private ChatMapper chatMapper;
	private Map<String, ChatRoom> chatRoomMap;
	
	// 의존성 주입이 이루어진 후 초기화를 수행, 여러번 초기화되는 것을 방지
	@PostConstruct
	private void init() {
		chatRoomMap = new LinkedHashMap<>();
	}
	// 채팅목록 조회
	public List<ChatRoom> findAllRooms(){
		List<ChatRoom> result = new ArrayList<>(chatRoomMap.values());
				
		Collections.reverse(result); // create_date DESC
		
		return result;
	}
	// 채팅방 불러오기(입장)
	public ChatRoom findRoomById(String id) {
		return chatRoomMap.get(id);
	}
	// 생성
	public ChatRoom createChatRoom() {
		ChatRoom room = ChatRoom.create();
		chatRoomMap.put(room.getRoomId(), room);
		
		return room;
	}
}*/