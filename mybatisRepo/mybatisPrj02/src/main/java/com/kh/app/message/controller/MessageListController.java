package com.kh.app.message.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.message.service.MessageService;

@WebServlet("/message/list")
public class MessageListController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//
		
		MessageService service = new MessageService();
		List<String> list = service.selectMsgList();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/views/message/list.jsp").forward(req, resp);
		
		
	}
}
