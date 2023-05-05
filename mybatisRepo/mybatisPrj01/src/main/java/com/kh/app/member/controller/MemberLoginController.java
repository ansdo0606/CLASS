package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/loginForm.jsp").forward(req, resp);
	
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String memberId = req.getParameter("memberId");
			String memberPwd = req.getParameter("memberPwd");
			
			MemberVo vo = new MemberVo();
			vo.setId(memberId);
			vo.setPwd(memberPwd);
			
			MemberService ms = new MemberService();
			MemberVo loginMember = ms.login(vo);
			
			if (loginMember != null) {
				req.getSession().setAttribute("loginMember", loginMember);
				resp.sendRedirect("/app01/home");
				
			}else {
				throw new Exception();
			}
			
		}catch (Exception e) {
			System.out.println("[ERROR] 로그인 중 예외발생");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "error");
			req.getRequestDispatcher("/errorPage").forward(req, resp);
		}
	}
}
