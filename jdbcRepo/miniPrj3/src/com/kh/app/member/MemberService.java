package com.kh.app.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.app.main.Main;
import com.kh.app.util.JDBCTemplate;

public class MemberService {
	
	//회원가입
	public void join() throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//입력받기
		System.out.print("아이디 : ");
		String id = Main.SC.nextLine();
		System.out.print("비밀번호 : ");
		String pwd = Main.SC.nextLine();
		System.out.print("닉네임 : ");
		String nick = Main.SC.nextLine();
		
		//sql
		String sql = "INSERT INTO MEMBER (NO, ID, PWD, NICK) VALUES(SEQ_MEMBER_NO.NEXTVAL,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		pstmt.setString(3, nick);
		int result = pstmt.executeUpdate();
		
		//result
		if (result == 1) {
			System.out.println("회원가입 성공");
			conn.commit();
		}else {
			System.out.println("회원가입 실패");
		}
		//close
		conn.close();
	}
	//로그인 
	public void login() throws Exception {

		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//입력받기
		System.out.print("아이디 : ");
		String id = Main.SC.nextLine();
		System.out.print("비밀번호 : ");
		String pwd = Main.SC.nextLine();
		
		//sql
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		ResultSet rs = pstmt.executeQuery();
		
		//result
		if (rs.next()) {
			//성공
			
			System.out.println("로그인 성공");
			
			String nick = rs.getString("NICK");

			System.out.println(nick + " 님 환영합니다.");
		}else {
			System.out.println("로그인 실패");
		}
		
		//close
		conn.close();
	
	}
	//수정
	public void update() throws Exception {

		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//입력받기
		System.out.print("비번 변경할 회원번호 : ");
		String no = Main.SC.nextLine();
		System.out.print("변경할 비밀번호 : ");
		String pwd = Main.SC.nextLine();
		
		//sql
		String sql ="UPDATE MEMBER SET PWD = ? WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, pwd);
		pstmt.setString(2, no);
		int result = pstmt.executeUpdate();
		
		//result
		if (result == 1) {
			System.out.println("변경 성공");
			conn.commit();
		}else {
			System.out.println("변경 실패");
		}
		//close
		conn.close();
	
	}
	//삭제
	public void delete() throws Exception {

		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//입력받기
		System.out.print("삭제할 회원번호 : ");
		String no = Main.SC.nextLine();
		
		//sql
		String sql ="DELETE MEMBER WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		
		//result
		if (result == 1) {
			System.out.println("탈퇴 성공");
			conn.commit();
		}else {
			System.out.println("탈퇴 실패");
		}
		//close
		conn.close();
	
	}
}
