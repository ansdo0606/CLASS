package com.kh.app.member.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.file.FileUploader;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {

	@GetMapping("/member/join")
	public String join() {
		return "member/join";
	}
	
	
	@PostMapping("/member/join")
	public void join(HttpServletRequest req , MemberVo vo) throws Exception{
		log.info(vo.toString());
		
		//서버에 저장start
		String path = req.getServletContext().getRealPath("/resources/img/member/");
		String changeName = FileUploader.saveFile(vo.isProfileEmpty(), path, vo.getMemberProfile());
		
		
		//서버에 저장end
		
		//디비에 저장
//		vo.setChangeName(이름)
//		vo.setOriginName(이름)
		
		
		
		
//		System.out.println(vo.getMemberProfile()[0]);
//		System.out.println(vo.getMemberProfile()[1]);
//		
//		if (!vo.getMemberProfile().isEmpty()) {
//			System.out.println("파일있음");
//		}else {
//			System.out.println("파일없음");
//		}
	}

}
