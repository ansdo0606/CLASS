package com.kh.app;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
	
	private final MemberService ms;
	
	@Autowired
	public MemberController(MemberService ms) {
		this.ms = ms;
	}
	
	@GetMapping("join")
	public String join() {
		
		return "join";
	}
	
	@PostMapping("join")
	@ResponseBody
	public String join(@RequestParam Map<String,String> paramMap) {
	
		int result = ms.join(paramMap);
		if (result == 1) {
			return "ok";
		}else {
			return "fail";
		}
	}
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@PostMapping("login")
	@ResponseBody
	public String login(@RequestParam Map<String, String> paramMap) {
		Map<String, String> memberMap = ms.login(paramMap);
		return memberMap.get("ID") + "님 로그인 성공";
	}
}
