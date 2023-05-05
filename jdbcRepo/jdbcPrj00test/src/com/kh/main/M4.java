package com.kh.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class M4 {

	public static void main(String[] args) throws Exception{

		//연결준비(드라이버 등록,url,id,pwd 준비)
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String id = "KH";
		String pwd = "KH";
		
		Class.forName(driver);
		
		// DB연결(url,id,pwd)=커넥션 객체 얻기
		Connection conn = DriverManager.getConnection(url,id,pwd);
		
		//유저 입력받기
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디 : ");
		String memberId = sc.nextLine();
		System.out.println("패스워드 : ");
		String memberPwd = sc.nextLine();
		System.out.println("닉네임 : ");
		String memberNick = sc.nextLine();
		
		//쿼리문 준비
		String sql = "INSERT INTO MEMBER(ID,PWD,NICK) VALUES(?,?,?)";
		
		//쿼리문 실행(pstmt)
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberId);
		pstmt.setString(2, memberPwd);
		pstmt.setString(3, memberNick);
		pstmt.execute();
		
		//커넥션 종료
		conn.close();
	}

}
