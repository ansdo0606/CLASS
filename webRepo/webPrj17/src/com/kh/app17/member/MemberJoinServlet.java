package com.kh.app17.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/join")
public class MemberJoinServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/joinForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//데이터 꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		
		//비지니스 로직
		System.out.println(memberId);
		System.out.println(memberPwd);

		//결과
		int result = 1;
		
		//화면 선택
		if (result == 1) {
			req.setAttribute("x", memberId);
			req.getRequestDispatcher("/WEB-INF/views/joinSuccess.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("").forward(req, resp);

		}
	
	}
}
