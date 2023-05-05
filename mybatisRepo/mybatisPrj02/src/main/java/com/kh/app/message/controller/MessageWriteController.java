package com.kh.app.message.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.message.service.MessageService;

@WebServlet("/message/write")
public class MessageWriteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/message/writeForm.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String msg = req.getParameter("msg");
			
			MessageService service= new MessageService();
			int result = service.write(msg);
			
			if (result == 1) {
				resp.sendRedirect("/app02/home");
				
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("[ERROR]");
			e.printStackTrace();
			req.setAttribute("error", "error");
			req.getRequestDispatcher("error").forward(req, resp);
		}
		
	}
}
