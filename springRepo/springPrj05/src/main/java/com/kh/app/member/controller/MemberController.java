package com.kh.app.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.app.member.vo.MemberVo;

@Controller
public class MemberController {
	
	@PostMapping
	public void join(MemberVo vo) {
		System.out.println("전달받은 데이터 : " + vo);
		
	}
}
