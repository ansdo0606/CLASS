package com.kh.app.message.service;

import org.apache.ibatis.session.SqlSession;

import java.util.List;
import com.kh.app.message.dao.MessageDao;
import com.kh.app.util.JDBCTemplate;

public class MessageService {

	public int write(String msg) {
		
		SqlSession ss = JDBCTemplate.getSqlSession();
	
		MessageDao dao = new MessageDao();
		int result = dao.write(ss,msg);
		
		if (result == 1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		
		ss.close();
		
		return result;
	}

	public int del(String msg) {
		
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		MessageDao dao = new MessageDao();
		int result = dao.del(ss,msg);
		
		if (result == 1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		
		ss.close();
		
		return result;
	
	}

	public List<String> selectMsgList() {
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		MessageDao dao = new MessageDao();
		List<String> list = dao.selectMsgList(ss);
		
		ss.close();
		
		return list;
		
	}

}
