package com.kh.app.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("member")
public class MemberController {
	
	@GetMapping("join")
	public void join() {
		
	}
	
	//@PostMapping("join")
//	public void join() {
//		
//	}
	//중복검사 -> 아이디 받아서  디비에 있는지 검사하고 중복여부 리턴하는 메소드
	@PostMapping("idCheck")
	@ResponseBody
	public String idCheck(String mid) {
		
		int result = 1;
		
		if (result > 0) {
			//중복 ㅇㅇ
			return "bad";
		}else {
			//중복ㄴㄴ
			return "good";
		}
		
	}
}
