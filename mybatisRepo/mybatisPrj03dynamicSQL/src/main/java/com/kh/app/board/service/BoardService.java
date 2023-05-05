package com.kh.app.board.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.common.db.SqlSessionTemplate;

public class BoardService {

	public int write(BoardVo boardVo) {
		
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		
		BoardDao dao = new BoardDao();
		int result = dao.write(ss,boardVo);
		
		if (result == 1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		
		ss.close();
		
		return result;
	}

	public List<BoardVo> selectBoardList() {
		
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		
		BoardDao dao = new BoardDao();
		List<BoardVo> list = dao.selectBoardList(ss);
		
		ss.close();
		
		return list;
	
	}

	public List<BoardVo> searchList(Map<String, String> map) {
		
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		
		BoardDao dao = new BoardDao();
		List<BoardVo> list = dao.search(ss,map);
		
		ss.close();
		
		return list;
		
		
	}

	
	
	
}
