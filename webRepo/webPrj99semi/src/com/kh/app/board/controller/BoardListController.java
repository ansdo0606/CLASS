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
import com.kh.app.util.page.PageVo;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet{
	
	private BoardService bs = new BoardService();

	//게시글 목록 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//데이터 꺼내기
			int currentPage = Integer.parseInt(req.getParameter("page"));
			int listCount = bs.selectCount();
			int pageLimit = 5;
			int boardLimit = 5;
			
			//데이터 뭉치기
			PageVo pageVo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
			
			
			//서비스 호출
			List<BoardVo> boardList = bs.selectList(pageVo);
				
			//화면
			req.setAttribute("boardList", boardList);
			req.setAttribute("pageVo", pageVo);
			req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
			
			
			
		} catch (Exception e) {
			System.out.println("[ERROR] 게시글 조회 중 예외 발생");
			e.printStackTrace();
			req.getRequestDispatcher("WEB-INF/views/common/error.jsp").forward(req, resp);
		
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	
	}
}

/*
 * 	maxPage : 제일 마지막 페이지
	listCount,boardLimit 로 계산
	ex) 게시글이 10개씩 보여지는 상황 == (boradLimit == 10)
	
	int maxPage = (int)Math.ceil((double)listCount/boardLimit);
	
	startPage : 페이징 영역의 첫번째 값
	pageLimit, currentPage
	
	int startPage = (currentPage - 1)/pageLimit*pageLimit + 1;
	
	int endPage = startPage + pageLimit-1;
	if (endPage > maxPage) {
		endPage = maxPage;
	}
 
 * */
