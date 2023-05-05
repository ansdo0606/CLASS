package com.kh.app.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.JDBCTemplate;

public class MemberDao {

	public int join(SqlSession ss, MemberVo vo) throws Exception {
		
		return ss.insert("member.join",vo);
//		String sql = "INSERT INTO MEMBER(NO,ID,PWD,NICK) VALUES (SEQ_MEMBER_NO.NEXTVAL,?,?,?)";
//		PreparedStatement pstmt = ss.prepareStatement(sql);
//		pstmt.setString(1, vo.getId());
//		pstmt.setString(2, vo.getPwd());
//		pstmt.setString(3, vo.getNick());
//		int result = pstmt.executeUpdate();
//		
//		
//		JDBCTemplate.close(pstmt);
//		
//		return result;
	}

	public MemberVo login(SqlSession ss, MemberVo vo) throws Exception {
		
		return ss.selectOne("member.login",vo);
		
//		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?";
//		PreparedStatement pstmt = ss.prepareStatement(sql);
//		pstmt.setString(1, vo.getId());
//		pstmt.setString(2, vo.getPwd());
//		ResultSet rs = pstmt.executeQuery();
//		
//		MemberVo loginMember = null;
//		if (rs.next()) {
//			String no = rs.getString("NO");
//			String id = rs.getString("ID");
//			String pwd = rs.getString("PWD");
//			String nick = rs.getString("NICK");
//			
//			loginMember = new MemberVo();
//			loginMember.setNo(no);
//			loginMember.setId(id);
//			loginMember.setPwd(pwd);
//			loginMember.setNick(nick);
//		
//		}
//		JDBCTemplate.close(pstmt);
//		JDBCTemplate.close(rs);
//		
//		return loginMember;
	}

	public int edit(SqlSession ss, MemberVo vo) throws Exception {

		return ss.update("member.edit", vo);
//		String sql = "UPDATE MEMBER SET PWD = ?, NICK = ? WHERE NO = ?";
//		PreparedStatement pstmt = ss.prepareStatement(sql);
//		pstmt.setString(1, vo.getPwd());
//		pstmt.setString(2, vo.getNick());
//		pstmt.setString(3, vo.getNo());
//		int result = pstmt.executeUpdate();
//		
//		JDBCTemplate.close(pstmt);
//	
//		return result;
	}

	public MemberVo selectOneByNo(SqlSession ss, String no) throws Exception {
		
		return ss.selectOne("member.selectOneByNo", no);
//		String sql = "SELECT * FROM MEMBER WHERE NO = ?";
//		PreparedStatement pstmt = ss.prepareStatement(sql);
//		pstmt.setString(1, no);
//		ResultSet rs = pstmt.executeQuery();
//		
//		MemberVo updatedMember = null;
//		if (rs.next()) {
//			String id = rs.getString("ID");
//			String pwd = rs.getString("PWD");
//			String nick = rs.getString("NICK");
//			
//			updatedMember = new MemberVo();
//			updatedMember.setNo(no);
//			updatedMember.setId(id);
//			updatedMember.setPwd(pwd);
//			updatedMember.setNick(nick);
//		
//		}
//		
//		JDBCTemplate.close(rs);
//		JDBCTemplate.close(pstmt);
//	
//	
//		return updatedMember;
	}

	public int quit(SqlSession ss, String no) {

		return ss.delete("member.quit",no);
		
	}

}
