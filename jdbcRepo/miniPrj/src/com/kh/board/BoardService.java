package com.kh.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kh.jdbc.JDBCTemplate;
import com.kh.main.Main;
import com.kh.member.MemberData;

public class BoardService {

	//게시글 작성
	public void write() throws Exception {
		
		if (Main.loginMember == null) {
			System.out.println("회원만 가능한 기능입니다.");
			return;
		}
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//입력받기
		System.out.println("제목 : ");
		String title = Main.SC.nextLine();
		System.out.println("내용 : ");
		String content = Main.SC.nextLine();
		
		
		
		//sql
		String sql = "INSERT INTO BOARD (NO,TITLE, CONTENT,WRITER) VALUES (SEQ_BOARD_NO.NEXTVAL,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setString(3, Main.loginMember.getNo()); //로그인한 유저의 회원번호를 넣어야함 이따 수정
		int result = pstmt.executeUpdate();
		
		//result
		if (result == 1) {
			System.out.println("게시글 작성 성공");
			conn.commit();
		}else {
			System.out.println("게시글 작성 실패");
		}
		
		//close
		conn.close();
	}
	//게시글 목록 조회
	public void selectList() throws Exception {
	
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		
		//sql
		String sql = "SELECT B.NO ,B.TITLE ,B.ENROLL_DATE ,M.NICK FROM BOARD B JOIN MEMBER M ON (B.WRITER = M.NO) WHERE B.DELETE_YN = 'N' ORDER BY B. NO DESC";
		PreparedStatement pstmt =conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<BoardData> list = new ArrayList<>();
		//result
		while(rs.next()) {
		//rs -> var
		String no = rs.getString("NO");
		String title = rs.getString("TITLE");
		String enrollDate = rs.getString("ENROLL_DATE");
		String nick = rs.getString("NICK");
		
		//var -> obj
		BoardData data = new BoardData();
		data.setNo(no);
		data.setTitle(title);
		data.setEnrollDate(enrollDate);
		data.setNick(nick);
		
		list.add(data);
	}
		//출력
		BoardPrinter bp = new BoardPrinter();
		bp.printBoardList(list);
		//close
		
		
	}
	//게시글 상세조회
	public void selectOne() throws Exception{
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		System.out.println("조회할 게시글 번호 : ");
		String num =Main.SC.nextLine();
		//sql
		String sql ="SELECT B.NO ,TITLE ,CONTENT,WRITER ,B.ENROLL_DATE ,NICK FROM BOARD B JOIN MEMBER M ON (B.WRITER = M.NO) WHERE DELETE_YN = 'N' AND B.NO = ?";
		PreparedStatement pstmt =conn.prepareStatement(sql);
		pstmt.setString(1, num);
		ResultSet rs = pstmt.executeQuery();
		
		//result
		if (rs.next()) {
		
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writer = rs.getString("WRITER");
			String enrollDate = rs.getString("ENROLL_DATE");
			String nick = rs.getString("NICK"); //RS에서 꺼내오기

			//객체로 변경하기
			BoardData data = new BoardData();
			data.setNo(no);
			data.setTitle(title);
			data.setContent(content);
			data.setWriter(writer);
			data.setEnrollDate(enrollDate);
			data.setNick(nick); //OBJ
			
			//결과출력
			BoardPrinter bp = new BoardPrinter();
			bp.printBoardOne(data);
		}else {
			System.out.println("조회실패");
		}
		
		
		//close
		conn.close();
		
	}
	//게시글 수정
	public void update() throws Exception {
	
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//입력받기
		System.out.println("글 번호 입력 : ");
		String num = Main.SC.nextLine();
		System.out.println("글 내용 입력 : ");
		String content = Main.SC.nextLine();
		
		
		
		//sql
		String sql ="UPDATE BOARD SET CONTENT = ? WHERE NO = ?";
		PreparedStatement pstmt =conn.prepareStatement(sql);
		pstmt.setString(1, content);
		pstmt.setString(2, num);
		int result = pstmt.executeUpdate();
		
		//result
		if (result == 1) {
			System.out.println("게시글 수정 성공");
			conn.commit();
		}else {
			System.out.println("게시글 수정 실패");
		}
		//close
		conn.close();
	}
	//게시글 삭제
	public void delete() throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//입력받기
		System.out.print("삭제할 게시글 번호 입력 :");
		String num = Main.SC.nextLine();
		//sql
		String sql = "UPDATE BOARD SET DELETE_YN = 'Y' WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(num));
		int result = pstmt.executeUpdate();
		
		//result
		if (result == 1) {
			System.out.println("게시글 삭제 성공");
			conn.commit();
		}else {
			System.out.println("게시글 삭제 실패");
		}
		//close
		conn.close();
	}
}
