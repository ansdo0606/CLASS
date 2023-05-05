package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/joinForm.jsp").forward(req, resp);
	
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//데이터 꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		String memberNick = req.getParameter("memberNick");
		
		//데이터 뭉치기 
		MemberVo vo = new MemberVo(); 
		vo.setId(memberId);
		vo.setPwd(memberPwd);
		vo.setNick(memberNick);
		
		int result = 0;
		try {
			//비지니스 로직
			MemberService service = new MemberService();
			result = service.join(vo);
			
		} catch (Exception e) {
			System.out.println("[ERROR] 회원가입 예외발생");
			e.printStackTrace();
			
		}
		
		//화면
		if (result == 1) {
			req.getSession().setAttribute("alertMsg", "회원가입 성공");
			resp.sendRedirect("/app23");
		}else {
			
			req.setAttribute("errorMsg", "회원가입 실패");
			req.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
	}
}
