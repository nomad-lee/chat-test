package com.buckwheat.chat.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buckwheat.chat.common.TeamColor;
import com.buckwheat.chat.mapper.ChatMapper;
import com.buckwheat.chat.vo.Chatting;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class ChatService {
	@Autowired
	private ChatMapper chatMapper;
	
	// 채팅방 개설
	public int addChattingRoom() {
		return chatMapper.insertChattingRoom();
	}
	
	// 채팅방 조회
	public List<Map<String, Object>> findAllRooms(){
		//List<ChattingRoom> result = new ArrayList<>(chattingRoomMap.values());
		
		List<Map<String, Object>> ChattingRooms = chatMapper.selectChattingRoomList();
		System.out.println(ChattingRooms + "ddddddddddddd");
		log.debug(TeamColor.CSK + ChattingRooms + "모든 채팅방 보여주기");
		//Collections.reverse(result); // create_date DESC
		
		return ChattingRooms;
	}
	
	// 메세지 보내기
	public int addChattingMsg(Chatting message) {
		System.out.println(message + "넘어오나");
		return chatMapper.insertChattingMsg(message);
	}
	
	// 메세지 불러오기
	public List<Map<String, Object>> getChattingList(int chattingRoomNo) {
		List<Map<String, Object>> messages = chatMapper.selectChattingList(chattingRoomNo);
		
		return messages;
	}
}