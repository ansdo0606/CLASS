package com.kh.app.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {
	public static void main(String[] args) throws Exception {
		
		System.out.println("test");
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "MINI";
		String pwd = "1234";
		Connection conn = DriverManager.getConnection(url,id,pwd);
		
		String sql = "INSERT INTO MEMBER (NO,ID,PWD,NICK) VALUES (SEQ_MEMBER_NO.NEXTVAL,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "user88");
		pstmt.setString(2, "6789");
		pstmt.setString(3, "user88^^");
		pstmt.execute();
		
		System.out.println("end");
		conn.close();
	}
}
