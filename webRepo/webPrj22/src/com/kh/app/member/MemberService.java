package com.kh.app.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kh.app.util.JDBCTemplate;

public class MemberService {
	
	public int join(MemberVo vo) {
		
		//유효성 검사 등 비지니스 로직
		
		//conn
		Connection conn = JDBCTemplate.getConnection();

		//SQL
		MemberDao dao = new MemberDao();
		int result = dao.join(conn, vo);
		
		//result
		if (result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
		
	//로그인
	public MemberVo login(MemberVo vo) {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//sql
		MemberDao dao = new MemberDao();
		MemberVo loginMember = dao.login(conn, vo);
		
		//close
		JDBCTemplate.close(conn);
		
		//result
		return loginMember;	
	}
	
}
