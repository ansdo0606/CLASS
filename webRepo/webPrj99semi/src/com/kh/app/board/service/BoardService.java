package com.kh.app.board.service;

import java.sql.Connection;
import java.util.List;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.AttachmentVo;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.util.JDBCTemplate;
import com.kh.app.util.page.PageVo;

public class BoardService {

	//게시글 조회
	public List<BoardVo> selectList(PageVo pageVo) throws Exception {
		
		//비지니스 로직
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//sql(dao)
		BoardDao dao = new BoardDao();
		List<BoardVo> boardList =  dao.selectList(conn ,pageVo);
		
		//tx, close
		JDBCTemplate.close(conn);
		
		
		return boardList;
	}
	//게시글 작성(+첨부파일 인서트)
	public int write(BoardVo vo, AttachmentVo atVo) throws Exception {

		//비지니스 로직
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
				
		BoardDao dao = new BoardDao();
		//sql(dao) == 게시글 인서트
		int result = dao.write(conn, vo);

		//sql (dao)== 첨부파일 인서트
		int atResult = dao.insertAttachment(conn, atVo);
		
		
		//tx,close
		if (result * atResult == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result * atResult;
	}

	//게시글 전체 갯수 조회 (삭제되지 않은)
	public int selectCount() throws Exception{
		
		//비지니스 로직
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//sql(dao)
		BoardDao dao = new BoardDao();
		int result = dao.selectCount(conn);
		
		//tx,close
		JDBCTemplate.close(conn);
		
		//return
		return result;
	}

	//게시글 상세 조회
	public BoardVo selectOne(String no) throws Exception {
		
		//비지니스 로직
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//sql dao(조회쿼리 + 증가쿼리)
		BoardDao dao = new BoardDao();
		int result = dao.increaseHit(conn, no);
		
		if (result != 1) {
			//문제발생
			throw new Exception("[ERROR] 조회수 증가 실패");
		}
		BoardVo boardVo = dao.selectOne(conn , no);
		
		
		//tx,close
		JDBCTemplate.commit(conn);
		JDBCTemplate.close(conn);
		
		//return
		return boardVo;

	}
}
