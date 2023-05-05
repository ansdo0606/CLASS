package com.kh.app.message.dao;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MessageDao {

	public int write(SqlSession ss, String msg) {
		return ss.insert("message.write", msg);
	}

	public int del(SqlSession ss, String msg) {
		return ss.delete("message.del", msg);
	}

	public List<String> selectMsgList(SqlSession ss) {
		return ss.selectList("message.selectMsgList");
	
	}
	
}
