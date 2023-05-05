package com.kh.app.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.kh.app.template.JDBCTemplate;

//비지니스 로직 실행
public class MemberService {

	//회원가입
	public int join(MemberVo vo) throws Exception {
		
		//유효성 검사
		//vo.getPwd().length() > 4
				
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//입력받기
		
		MemberDao dao = new MemberDao();
		int result = dao.join(conn,vo);
		
		
		//result
		if(result == 1 ) {
			//성공로직
			conn.commit();
		}else {
			conn.rollback();
		}
		//close
		conn.close();
		return result;
		
	}
	
}
