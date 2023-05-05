package com.kh.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

	public static void main(String[] args) throws Exception{
		
		System.out.println("zzz");
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url= "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String id= "KH";
		String pwd= "KH";
		
		Class.forName(driver);
		
		// DB연결(url,id,pwd)=커넥션 객체 얻기
		Connection conn = DriverManager.getConnection(url,id,pwd);
		//조회
		String sql = "SELECT * FROM MEMBER";
		//pstmt로 쿼리문 실행
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//execute(); => 리턴값이 int라서 DML구문에서 사용
		ResultSet rs = pstmt.executeQuery(); 
		
		//rs에서 데이터 꺼내기 (아이디, 패스워드, 닉네임)
		rs.next(); //cursor 한칸 내리기
		String dbId = rs.getString("ID");
		String dbPwd = rs.getString("PWD");
		String dbNick = rs.getString("NICK");
		
		System.out.println(dbId);
		System.out.println(dbPwd);
		System.out.println(dbNick);
		
		conn.close();
		
	}

}
