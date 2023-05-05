package com.kh.app.main;

import java.util.Scanner;

import com.kh.app.member.MemberController;

public class Main {

	public static final Scanner SC = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("==========");
		
		System.out.println("1.회원가입");

		String input = SC.nextLine();
		
		//회원가입
		MemberController mc = new MemberController();
		try {
			mc.join();
			
		} catch (Exception e) {
			System.out.println("회원가입 오류발생");
			e.printStackTrace();
			
		}
		
	}

}
