package com.kh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.sql.json.OracleJsonNumber;

public class JDBCTemplate {
	
	//커넥션 얻기
	public static Connection getConnection() throws Exception {
		//디비연결 == 커넥션 객체 얻기
		
		/*
		 * 1. OJDBC 드라이버 준비
		 * 2. 드라이버매니저 이용해서 커넥션 얻기 (getConnection)
		 * */
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String username ="MINI";
		String password ="1234";
		Connection conn = DriverManager.getConnection(url,username,password);
		conn.setAutoCommit(false);
		return conn;	
	}
}
