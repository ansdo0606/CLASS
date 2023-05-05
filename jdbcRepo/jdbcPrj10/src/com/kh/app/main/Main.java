package com.kh.app.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		System.out.println("시작");
		
		//회원가입 (디비연결, sql, 결과, 정리)
		
		//디비연결(커넥션 얻기)
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "MINI";
		String pwd = "1234";
		Connection conn = DriverManager.getConnection(url,id,pwd);
		
		String sql ="INSERT INTO MEMBER (NO,ID,PWD,NICK) VALUES (SEQ_MEMBER_NO.NEXTVAL,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql); 
		pstmt.setString(1, "user672384");
		pstmt.setString(2, "1329235");
		pstmt.setString(3, "nick3709852");
		int result = pstmt.executeUpdate();
		
		if (result == 1) {
			System.out.println("회원가입 성공");
		}else {
			System.out.println("회원가입 실패");
		}
		System.out.println("종료");
		conn.close();
		
		
		
		
	}

}
