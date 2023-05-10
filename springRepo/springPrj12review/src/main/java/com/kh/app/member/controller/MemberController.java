package com.kh.app.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.member.vo.MemberVo;

@Controller
public class MemberController {
	
	@RequestMapping("/join")
	public String m01(MemberVo vo ) {
		System.out.println(vo);
		return "member/join";
	}
}
