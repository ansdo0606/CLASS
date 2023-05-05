package com.kh.app.message.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.message.service.MessageService;

@WebServlet("/message/del")
public class MessageDelController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/message/delForm.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//DELETE FROM MESSAGE WHERE MSG = ?
		try {
			String msg = req.getParameter("msg");
			
			MessageService service = new MessageService();
			int result = service.del(msg);
			
			if (result == 1) {
				resp.sendRedirect("/app02/home");
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("[ERROR]");
			e.printStackTrace();
			
		}
	}
	
}
