package com.kh.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class M0 {
	//insert
	public static void main(String[] args) throws Exception{
		//1.연결 준비(url,id,pwd 준비)
		Connection conn = null;
		
		String id = "KH";
		String pwd = "KH";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		//2. DB 커넥션 객체 생성
		Class.forName("oracle.jdbc.OracleDriver");//오라클 드라이버 등록하는 과정
		conn = DriverManager.getConnection(url,id,pwd);//커넥션 객체 받기
		
		//3.쿼리문 준비
		String sql = "INSERT INTO MEMBER (ID,PWD,NICK) VALUES ('anna','12345','anenmone')";
		
		//4. 쿼리문 실행
		Statement stmt =conn.createStatement();
		int result = stmt.executeUpdate(sql);
		System.out.println("result : "+ result);
		
		//5. 쿼리문 종료
		conn.close();
	}

}
