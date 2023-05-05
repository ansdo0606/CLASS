package com.kh.app.member.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.app.HomeController;
import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	
	private final MemberService ms;
	
	@Autowired
	public MemberController(MemberService x) {
		this.ms = x;
	}
	
	
	//private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	//로그인
	@GetMapping("member/login")
	public String login() {

		log.debug("login called");
		
		return "member/login-form";
	}
	
	@PostMapping("member/login")
	public String login(MemberVo vo) throws Exception{
		
		
		MemberVo result = ms.login(vo);
		
		if (result == null) {
			return "/error-page";
		}
		return "redirect:/success-page";
	}
	
	@RequestMapping("test")
	@ResponseBody
	public String test(HttpServletResponse resp ,@CookieValue(required = false) String atk) {
		
		//cookie 만들어주기 (key , value) //문자열만 가능
		Cookie cookie = new Cookie("atk", "777");
		cookie.setMaxAge(60 * 60);
		resp.addCookie(cookie);
		
		return "cookie create";
	}
}
