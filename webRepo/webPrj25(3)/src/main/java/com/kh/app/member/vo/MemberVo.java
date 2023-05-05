package com.kh.app.member.vo;

public class MemberVo {
	
	private String no;
	private String id;
	private String pwd;
	private String nick;
	private String enrollerDate;
	private String quitYn;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getEnrollerDate() {
		return enrollerDate;
	}
	public void setEnrollerDate(String enrollerDate) {
		this.enrollerDate = enrollerDate;
	}
	public String getQuitYn() {
		return quitYn;
	}
	public void setQuitYn(String quitYn) {
		this.quitYn = quitYn;
	}
	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", id=" + id + ", pwd=" + pwd + ", nick=" + nick + ", enrollerDate="
				+ enrollerDate + ", quitYn=" + quitYn + "]";
	}
	public MemberVo(String no, String id, String pwd, String nick, String enrollerDate, String quitYn) {
		super();
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.nick = nick;
		this.enrollerDate = enrollerDate;
		this.quitYn = quitYn;
	}
	public MemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
