package com.kh.main;

import java.util.Scanner;

import com.kh.board.BoardService;
import com.kh.member.MemberData;
import com.kh.member.MemberService;

public class Main {

	public static final Scanner SC = new Scanner(System.in); 
	public static MemberData loginMember;
		
	
	
	public static void main(String[] args) throws Exception {
		System.out.println("========");
		
		MainService ms = new MainService(); 
		
		boolean isFinish = false;
		
		while (!isFinish) {
			isFinish = ms.start();
			
		}
			
		
		
	}

}
