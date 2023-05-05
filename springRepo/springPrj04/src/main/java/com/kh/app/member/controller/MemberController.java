package com.kh.app.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@Controller
public class MemberController {
 	
	@Autowired
	private MemberService ms;

	@GetMapping("member/join")
	public String join() {
		return "member/join";
	}
	@PostMapping("member/join")
	public String join(MemberVo vo) throws Exception {
	
			int result = ms.join(vo);

			if (result != 1) {
				return "commodm/error-page";
			}
			
			return "redirect:/home";		          
			
	}
}
