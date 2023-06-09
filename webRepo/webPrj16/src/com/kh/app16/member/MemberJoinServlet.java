package com.kh.app16.member;

import java.io.IOException;

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
		
		//JSP 선택(화면선택)
		req.getRequestDispatcher("/WEB-INF/view/joinForm.jsp").forward(req, resp);
	}
	
	
	//회원가입 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
	
		//비즈니스 로직
		System.out.println(memberId);
		System.out.println(memberPwd);
		
		//결과
		int result = 1;
		
		//문자열 내보내기
		if (result == 1 ) {
			req.setAttribute("x", memberId);
			req.getRequestDispatcher("/WEB-INF/view/joinSuccess.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("").forward(req, resp);
		}
		
	}
}
