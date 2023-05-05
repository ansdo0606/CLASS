package com.kh.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import com.kh.jdbc.JDBCTemplate;
import com.kh.main.Main;
import com.kh.main.MainMenu;

public class MemberService {
	
	private final MemberPrinter mp = new MemberPrinter();
	
	//회원가입(=DB에 insert) 
	public void join() throws Exception {
		
		//디비연결 == 커넥션 객체얻기
		Connection conn = JDBCTemplate.getConnection();
		
		System.out.println("아이디 : ");
		String memberId = Main.SC.nextLine();
		System.out.println("패스워드 : ");
		String memberPwd = Main.SC.nextLine();
		System.out.println("닉네임 : ");
		String memberNick = Main.SC.nextLine();
		//SQL실행
		String sql = "INSERT INTO MEMBER(NO,ID,PWD,NICK) VALUES(SEQ_MEMBER_NO.NEXTVAL,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberId);
		pstmt.setString(2, memberPwd);
		pstmt.setString(3, memberNick);
		int result = pstmt.executeUpdate();
		
		//메소드분리,입력받는거 따로처리
		
		
		//실행결과에 따라 처리 (1개 row가 insert가 되었는지)
		if (result == 1) {
			System.out.println("회원가입 성공");
			conn.commit();
		}else {
			System.out.println("회원가입 실패");
			conn.rollback();
		}
		//수동으로 처리할수 있다.(AutoCommit이 꺼져있을때만 가능)
		//자동커밋이 켜져있으면 트랜잭션 처리 직접 불가능
		//트랜잭션 관리 하고싶다? 그럼 자동커밋 끄기
		
		
		//정리
		conn.close();
		
	}
	//로그인 
	public void login() throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//입력받기
		System.out.println("아이디를 입력하세요 : ");
		String id = Main.SC.nextLine();
		System.out.println("비밀번호를 입력하세요 : ");
		String pwd = Main.SC.nextLine();
		
		//sql
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		ResultSet rs = pstmt.executeQuery();
		
		//result
		if (rs.next()) {
			//데이터 꺼내기 결과 꺼내기
			String no = rs.getString("NO");
			String memberId = rs.getString("ID");
			String memberPwd = rs.getString("PWD");
			String memberNick = rs.getString("NICK");
			
			//결과 출력
			System.out.println("=======로그인 성공 (유저정보)========");
			
			MemberData data = new MemberData();
			data.setNo(no);
			data.setId(memberId);
			data.setPwd(memberPwd);
			data.setNick(memberNick);
			mp.printMember(data);
			
			//로그인 정보 기억하기
			//변수 = 로그인정보;
			Main.loginMember = data;
			
		}else {
			System.out.println("로그인이 실패하였습니다.");
		}
		
		
		//close
		conn.close();
		
	}
	//수정
	public void edit() throws Exception {
		
		if (Main.loginMember == null) {
			System.out.println("로그인을 해주세요.");
			return;
		}
		
		//현재 유저 정보 출력(마이페이지)
		mp.printMember(Main.loginMember);
		
		Connection conn = JDBCTemplate.getConnection();
		//입력받기
		
		System.out.println("변경할 비밀번호 : ");
		String pwd = Main.SC.nextLine();
		
		
	    String sql = "UPDATE MEMBER SET PWD = ? WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, pwd);
		pstmt.setString(2, Main.loginMember.getNo());
		int result = pstmt.executeUpdate();

		if (result == 1) {
			System.out.println("수정 성공");
			conn.commit();
		}else {
			System.out.println("수정 실패");
		}
		conn.close();
	}
	//삭제
	public void quit() throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//회원번호 입력 받기
		System.out.println("탈퇴할 회원 번호 : ");
		String num_ = Main.SC.nextLine();
		int num = Integer.parseInt(num_);
		
		//sql
		String sql = "DELETE MEMBER WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, num);
		int result = pstmt.executeUpdate();
		//result
		if (result == 1) {
			System.out.println("탈퇴성공");
			conn.commit();
		}else {
			System.out.println("탈퇴실패");
		}
		//close
		conn.close();
}
	//회원 목록 조회
	public void selectList() throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//sql
		String sql = "SELECT * FROM MEMBER";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//result
		while (rs.next()) {
			String no = rs.getString("NO");
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String nick = rs.getString("NICK");
			String enrollDate = rs.getString("ENROLL_DATE");
			String quitYn = rs.getString("QUIT_YN");
			
			//출력
			MemberData data = new MemberData();
			
			data.setNo(no);
			data.setId(id);
			data.setPwd(pwd);
			data.setNick(nick);
			data.setEnrollDate(enrollDate);
			data.setQuitYn(quitYn);
			
			mp.printMember(data);
		}
		//close
		conn.close();

	}
}
