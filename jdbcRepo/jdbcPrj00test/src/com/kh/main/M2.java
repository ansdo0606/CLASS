package com.kh.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class M2 {

	public static void main(String[] args) throws Exception{
		//연결준비(드라이버 등록,url,id,pwd 준비)
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url= "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String id= "KH";
		String pwd= "KH";
		
		Class.forName(driver); //오라클 드라이버 클래스를 연결하기 위한 구문
		
		// DB연결(url,id,pwd)=커넥션 객체 얻기
		Connection conn = DriverManager.getConnection(url,id,pwd);
		
		//조회
		String sql = "SELECT * FROM MEMBER";
		
		//pstmt로 쿼리문 실행
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//execute(); => 리턴값이 int라서 DML구문에서 사용  
		//Data Manipulation Language : 데이터 조작어
		//select는 int가 아닌 ResultSet으로 받아줘야 됨으로
		//executeUpdate가 아닌 executeQuery로 받아줘야 된다.
		ResultSet rs = pstmt.executeQuery();
		
		//rs에서 데이터 꺼내기 (아이디, 패스워드, 닉네임)
		rs.next(); //cursor 한칸 내리기
		rs.next(); //cursor 한칸 내리기
		String dbId = rs.getString("ID");
		String dbPwd = rs.getString("PWD");
		String dbNick = rs.getString("NICK");
		 
		System.out.println(dbId);
		System.out.println(dbPwd);
		System.out.println(dbNick);
		
		//커넥션 종료
		conn.close();
	}

}
