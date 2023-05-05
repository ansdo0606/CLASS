package com.kh.app.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.app.common.file.FileUploader;
import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("member")
@Slf4j
public class MemberController {
	
	private final MemberService ms;

	@Autowired
	public MemberController(MemberService x) {
		this.ms = x;
	}
	
	
	@GetMapping("join")
	public void join() {
		log.trace("join called");
	}
	
	@PostMapping("join")
	public String join(MemberVo vo , HttpServletRequest req , HttpSession session , Model model) throws Exception{
		
		//파일 업로드
		String path = req.getServletContext().getRealPath("/resources/upload/member/");
		String changeName = FileUploader.upload(vo.getProfile() , path);
		vo.setProfileName(changeName);
		
		int result = ms.join(vo);
		
		if (result != 1) {
			model.addAttribute("errorMsg", "회원가입 실패");
			return "common/error-page";
		}
		session.setAttribute("alertMsg", "회원가입 성공");
		return "redirect:/home";
		
	}
	// 아이디 중복확인
	@RequestMapping("id-check")
	@ResponseBody
	public String idCheck(String id) {
		
		int result = ms.checkId(id);
		if (result > 0) {
			return "isDup";
		}else {
			return "notDup";
			
		}
	}
	
	//로그인
	@PostMapping("login")
	public String login(MemberVo vo ,HttpSession session) {
		
		MemberVo loginMember = ms.login(vo);
		
		if (loginMember == null) {
			session.setAttribute("alertMsg", "로그인 실패");
		}
		session.setAttribute("loginMember", loginMember);
		return "redirect:/home";
		
	}
	
	//로그아웃
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home";
	}
	
	//정보수정
	@GetMapping("edit")
	public String edit(HttpSession session , Model model ) {
		if (session.getAttribute("loginMember") == null) {
			model.addAttribute("errorMsg","로그인 후 이용 가능합니다.");
			return "common/error-page";
		}
		return "member/edit";
	}
	@PostMapping("edit")
	public String edit(MemberVo vo , Model model , HttpSession session) throws Exception {
		
		MemberVo updatedMember = ms.edit(vo);
		if (updatedMember == null) {
			model.addAttribute("errorMsg","정보수정실패");
			return "common/error-page";
		}
		session.setAttribute("loginMember", updatedMember);
		session.setAttribute("alertMsg", "정보수정성공");
		return "redirect:/home";
	}
	
	@RequestMapping("quit")
	public String quit(HttpSession session) {
		MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
		String no = loginMember.getNo();
		
		int result = ms.quit(no);
		
		if (result == 1 ) {
			session.invalidate();			
		}else {
			session.setAttribute("alertMsg", "회원탈퇴실패");
		}
		return "redirect:/home";
	}
}
