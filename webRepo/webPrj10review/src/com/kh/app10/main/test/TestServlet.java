package com.kh.app10.main.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("servlet method called");
	
		//통로만들어 내보내기
		PrintWriter out = resp.getWriter();
		out.write("<h1>java</h1>");
		//이 하위에 뭔가 많은 html을 작성하기 귀찮아서 만든게
		//jsp이다
		
	}
	
}
