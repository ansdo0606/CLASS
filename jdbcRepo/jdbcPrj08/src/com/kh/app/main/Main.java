package com.kh.app.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws Exception {
		
		System.out.println("회원가입진행");
		//회원가입
		//드라이버 연결,커넥션얻기
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String id="MINI";
		String pwd="1234";
		Connection conn = DriverManager.getConnection(url,id,pwd);
		
		//SQL
		String sql = "INSERT INTO MEMBER(NO,ID,PWD,NICK) VALUES (SEQ_MEMBER_NO.NEXTVAL,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "user004");
		pstmt.setString(2, "12567");
		pstmt.setString(3, "nick004s");
		int result = pstmt.executeUpdate();
		
		if (result == 1) {
			System.out.println("회원가입 성공");
		}else {
			System.out.println("회원가입 실패");
		}
		
		conn.close();
		
	}

}
