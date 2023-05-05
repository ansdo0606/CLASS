package com.kh.app.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kh.app.main.Main;
import com.kh.app.template.JDBCTemplate;

public class MemberController {
	public void join() throws Exception {
		
		//입력받기
		System.out.println("아이디 : ");
		String memberId = Main.SC.nextLine();
		System.out.println("비밀번호 : ");
		String memberPwd = Main.SC.nextLine();
		System.out.println("닉네임 : ");
		String memberNick = Main.SC.nextLine();
		
		MemberVo vo = new MemberVo();
		vo.setMemberId(memberId);
		vo.setMemberPwd(memberPwd);
		vo.setMemberNick(memberNick);
		
		
		//비즈니스로직
		MemberService ms = new MemberService();
		ms.join(vo);
		
	}
}
