package com.kh.app.member.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.JDBCTemplate;

public class MemberService {

	public int join(MemberVo vo) throws Exception {
		
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		MemberDao dao = new MemberDao();
		int result = dao.join(ss, vo);
		
		if (result == 1 ) {
			ss.commit();
		}else {
			ss.rollback();
		}
	
	     ss.close();
		
		
		return result;
	}

	public MemberVo login(MemberVo vo) throws Exception {
		
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		MemberDao  dao = new MemberDao();
		MemberVo loginMember = dao.login(ss, vo);
		
		ss.close();
		System.out.println( "마이바티스로 로그인한 결과 : "+loginMember);
		return loginMember;
	}

	public MemberVo edit(MemberVo vo) throws Exception {
		
		SqlSession ss = JDBCTemplate.getSqlSession();
		MemberVo updatedMember = null;

		try {
			MemberDao dao = new MemberDao();
			int result = dao.edit(ss,vo);
		
			if (result == 1) {
				updatedMember = dao.selectOneByNo(ss,vo.getNo());
				if (updatedMember == null) {
					ss.rollback();
					throw new Exception();
				}
				ss.commit();
			}else {
				ss.rollback();
			}
			
		} finally {
			ss.close();
		}
		
		return updatedMember;
		
	}

	public int quit(String no) {
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		MemberDao dao = new MemberDao();
		int result = dao.quit(ss,no);
		
		if (result == 1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		ss.close();
		
		return result;
	
	}

}
