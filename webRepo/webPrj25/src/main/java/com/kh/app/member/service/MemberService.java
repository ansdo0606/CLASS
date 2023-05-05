package com.kh.app.member.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.JDBCTemplate;

public class MemberService {
	public int join(MemberVo vo) throws Exception{
		
		Connection conn = JDBCTemplate.getConnection();
		
		MemberDao memberDao = new MemberDao();
		int result = memberDao.join(conn,vo);
		
		if (result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
}
