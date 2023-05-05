package com.kh.app.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kh.app.main.Main;
import com.kh.app.template.JDBCTemplate;

//입력받기
//데이터 뭉치기
//서비스 호출
public class MemberController {
	
	//회원가입
	public void join() throws Exception {
		
		System.out.println("아이디 : ");
		String memberId = Main.SC.nextLine();
		System.out.println("비밀번호 : ");
		String memberPwd = Main.SC.nextLine();
		System.out.println("닉네임 : ");
		String memberNick = Main.SC.nextLine();
	
		//데이터 뭉치기
		MemberVo vo = new MemberVo();
		vo.setId(memberId);
		vo.setPwd(memberPwd);
		vo.setNick(memberNick);
		
		MemberService ms = new MemberService();
		ms.join(vo);
		
	}
	
	//로그인
	
	
	//비번변경
	
	
	//탈퇴
}
