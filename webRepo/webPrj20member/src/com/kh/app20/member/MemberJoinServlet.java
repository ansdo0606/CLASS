package com.kh.app20.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/join")
public class MemberJoinServlet extends HttpServlet{
	
	//회원가입(화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//문자열 내보내기 ==> JSP에 요청 위임하기
		req.getRequestDispatcher("/WEB-INF/views/member/joinForm.jsp").forward(req, resp);
		
	}
	
	//회원가입(db에 insert)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		String memberNick = req.getParameter("memberNick");
		
		
		//커넥션 준비 (드라이버,conn)
		Connection conn;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			//tomcat에 jdbc를 연결하는거라 수동으로 써줘야됨
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "MINI";
			String pwd = "1234";
			conn = DriverManager.getConnection(url,id,pwd);
			
			//sql
			String sql = "INSERT INTO MEMBER(ID,PWD,NICK) VALUES (?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPwd);
			pstmt.setString(3, memberNick);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		//결과(tx,자원정리)
		
		if (result == 1) {
			//성공(commit 성공 안내 메세지)
			//req.getRequestDispatcher("/").forward(req, resp); -> 요청을 한번만 받는거
			resp.sendRedirect("/app20/index.html");//클라이언트가 요청보낼 경로를 적어준다. 요청을 여러번
			
			
		}else {
			//실패(rollback 실패 안내 메세지)
			req.setAttribute("msg", "회원가입 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
			
		}
		
	}
	
}
