package com.kh.app14.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/join")
public class MemberJoinServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		
		System.out.println(memberId);
		System.out.println(memberPwd);

		int result = 1;
		
		//전달할 데이터 담기
		req.setAttribute("x", memberId);
		
		//결과에 따라 문자열 내보내기 (== view만들기)
		if (result == 1) {
			RequestDispatcher rd = req.getRequestDispatcher("/joinSuccess.jsp");
			rd.forward(req, resp);
		}else {
			PrintWriter out = resp.getWriter();
			out.write("<h1>join fail</h1>");
		}
	}
}
