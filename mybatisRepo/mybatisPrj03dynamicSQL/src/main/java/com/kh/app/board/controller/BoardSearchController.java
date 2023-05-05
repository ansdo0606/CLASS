package com.kh.app.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@WebServlet("/board/search")
public class BoardSearchController extends HttpServlet{

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			req.setCharacterEncoding("UTF-8");
			
			String titleValue = req.getParameter("titleValue");
			String contentValue = req.getParameter("contentValue");
			String writerValue = req.getParameter("writerValue");
			
			Map<String, String> map = new HashMap<>();
			map.put("titleValue", titleValue);
			map.put("contentValue", contentValue);
			map.put("writerValue", writerValue);
			
			BoardService service = new BoardService();
			List<BoardVo> list = service.searchList(map);
			
			req.setAttribute("bvoList", list);
			req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
			
		} catch (Exception e) {
			System.out.println("[ERROR]");
			e.printStackTrace();
			
			req.setAttribute("error", "error");
			req.getRequestDispatcher("error").forward(req, resp);
		}
		
	}
}
