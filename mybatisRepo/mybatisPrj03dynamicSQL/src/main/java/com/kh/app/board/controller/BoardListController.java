package com.kh.app.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet{

	//SELECT * FROM BOARD
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			BoardService service = new BoardService();
			List<BoardVo> list = service.selectBoardList();
			
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
