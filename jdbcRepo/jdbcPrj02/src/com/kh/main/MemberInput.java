package com.kh.main;

import java.util.Scanner;

public class MemberInput {

	public static final Scanner SC= new  Scanner(System.in);
	
	public MemberData joinInput() {
		System.out.println("아이디 : ");
		String id =SC.nextLine();
		System.out.println("패스워드 : ");
		String pwd =SC.nextLine(); 
		System.out.println("닉네임 : ");
		String nick =SC.nextLine();
		MemberData data = new MemberData(id,pwd,nick);
		return data;
	}
	public MemberData loginInput() {
		System.out.println("아이디 : ");
		String id = SC.nextLine();
		System.out.println("패스워드 : ");
		String pwd = SC.nextLine(); 
		return new MemberData(id,pwd,null);
	}
}
