package com.buckwheat.chat.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.buckwheat.chat.common.TeamColor;
import com.buckwheat.chat.service.ChatService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ChatController {
	@Autowired
	private final ChatService chatService;
	
	@GetMapping("/login")
	public String login() {
		log.debug(TeamColor.CSK + "@GetMapping 로그인");
		
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String name, HttpSession session) {
		log.debug(TeamColor.CSK + name + " 로그인");
		session.setAttribute("login", name);
		
		return "redirect:/rooms";
	}
	
	// 채팅방 목록 조회
	@GetMapping("/rooms")
	public ModelAndView rooms() {
		log.debug(TeamColor.CSK + "모든 채팅방 보여주기");
		ModelAndView mv = new ModelAndView("rooms");
		
		mv.addObject("list", chatService.findAllRooms());
		
		return mv;
	}
	
	// 채팅방 개설
    @PostMapping("/rooms")
    public String create(){
    	chatService.addChattingRoom();
        return "redirect:/rooms";
    }
    
    // 임시 chat
	@GetMapping("/chat2")
	public String chat2() {
		
		return "chat2";
	}
	
	// 채팅방 조회
    @GetMapping("/chat")
    public String getChat(@RequestParam int chattingRoomNo, Model model){
    	log.debug(TeamColor.CSK + chattingRoomNo + "번 채팅방 입장");
    	log.debug(TeamColor.CSK + chattingRoomNo + "번 채팅방 정보");

		System.out.println(chatService.getChattingList(chattingRoomNo) + "ddddddddddddd" + chattingRoomNo + ".NO");
        model.addAttribute("chatList", chatService.getChattingList(chattingRoomNo));
        model.addAttribute("chattingRoomNo", chattingRoomNo);        
        
        return "chat";
    }	
}
