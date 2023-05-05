package com.kh.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws Exception{
		
		System.out.println("===JDBC===");
		
		//jdbc
		Connection conn = null;
		
		String id= "KH";
		String pwd= "KH";
		String url= "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		//DB 커넥션 객체 생성
		Class.forName("oracle.jdbc.OracleDriver");//오라클 드라이버 등록하는 과정
		conn = DriverManager.getConnection(url,id,pwd);//
		
		String sql ="INSERT INTO MEMBER(ID,PWD,NICK) VALUES ('BBB','5555','bbb')"; 
		
		Statement stmt = conn.createStatement();
		int result = stmt.executeUpdate(sql);
		System.out.println("result : " +result);
		
		conn.close();
	}//main

}//class
