package com.kh.app.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.kh.app.template.JDBCTemplate;

public class MemberService {

	public void join(MemberVo vo) throws Exception {

		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//sql
		MemberDao dao = new MemberDao();
		int result = dao.join(conn, vo);
		
		//result
		if (result == 1) {
			System.out.println("성공");
			conn.commit();
		}else {
			System.out.println("실패");
			conn.rollback();
		}
		//close
		conn.close();
	}
}
