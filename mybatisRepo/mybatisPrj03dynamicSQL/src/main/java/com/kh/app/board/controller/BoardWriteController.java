package com.kh.app.board.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/board/write.jsp").forward(req, resp);
	}
	
	//INSERT INTO BOARD(NO, TITLE , CONTENT, WRITER) VALUSE(SEQ_BOARD_NO.NEXTVAL,?,?,1)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//인코딩
			req.setCharacterEncoding("UTF-8");
			
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			BoardVo boardVo = new BoardVo();
			boardVo.setTitle(title);
			boardVo.setContent(content);
			
			BoardService bs = new BoardService();
			int result = bs.write(boardVo);
			
			String ip = req.getRemoteAddr();
	         File f = new File("C:/temp.log");
	         FileWriter fw = new FileWriter(f , true);
	         fw.write("[" + ip + "] ");
	         fw.write(title);
	         fw.write("\n");
	         fw.flush();
			
			if (result == 1) {
				resp.sendRedirect("/app03/board/list");
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("[ERROR]");
			e.printStackTrace();
			req.setAttribute("error", "error");
			req.getRequestDispatcher("errorPage").forward(req, resp);
			
		}
	}
}
