package com.kh.app.member.service;

import java.sql.Connection;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.JDBCTemplate;

public class MemberService {
	
	Connection conn = JDBCTemplate.getConnection();
	
	public int join(MemberVo vo) throws Exception {
		MemberDao dao = new MemberDao();
		
		int result = dao.join(conn,vo);

		if (result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
	
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	
}
