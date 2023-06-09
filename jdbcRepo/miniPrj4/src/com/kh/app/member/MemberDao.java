package com.kh.app.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

//Data Access Object 디비접근
public class MemberDao {
	
	//회원가입
	public int join(Connection conn,MemberVo vo) throws Exception {
		
		//sql
		String sql = "INSERT INTO MEMBER(NO, ID, PWD, NICK) VALUES(SEQ_MEMBER_NO.NEXTVAL,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		pstmt.setString(3, vo.getNick());
		int result = pstmt.executeUpdate();	
		return result;
	}
	
}

