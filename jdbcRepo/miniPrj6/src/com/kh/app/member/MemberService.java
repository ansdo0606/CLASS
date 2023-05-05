package com.kh.app.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kh.app.template.JDBCTemplate;

//비지니스 로직 처리
//conn 커넥션
//sql(dao 호출해서 진행)
//결과에 따라 처리
//close 정리
public class MemberService {
	
	public void join(MemberVo vo) throws Exception {
		//서비스 호출
		Connection conn = JDBCTemplate.getConnection();
		
		MemberDao dao = new MemberDao();
		int result = dao.join(conn, vo);
		
		if (result == 1) {
			System.out.println("회원가입 성공");
			conn.commit();
		}else {
			System.out.println("회원가입 실패");
			conn.rollback();
		}
		
		conn.close();
				
	}
}
