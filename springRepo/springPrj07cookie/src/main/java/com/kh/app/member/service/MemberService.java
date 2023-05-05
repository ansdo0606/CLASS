package com.kh.app.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

@Service
public class MemberService {
	
	private final SqlSessionTemplate sst;
	private final MemberDao dao;

	@Autowired
	public MemberService(SqlSessionTemplate a, MemberDao b) {
		this.sst = a;
		this.dao = b;
	}
	
	public MemberVo login(MemberVo vo) throws Exception{
		return dao.login(sst,vo);
	}

}
