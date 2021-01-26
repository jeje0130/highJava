package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

/*
 * - 회원을 관리하는 프로그램을 작성하시오.
 *   (오라클 DB의 mymember 테이블 이용)
 *   
 * - 아래 메뉴의 기능을 모두 구현하시오 (CRUD 구현하기 연습)
 * 메뉴 예시 )
 * 	-- 작업 선택 --
 *  1. 자료 추가
 *  2. 자료 삭제
 *  3. 자료 수정
 *  4. 전체 자료 출력
 *  0. 작업 끝
 *  -----------
 *  작업 선택>> 
 * 
 * 
 */


public class JdbcTest07 {
		Scanner scan = new Scanner(System.in);

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
	public static void main(String[] args) {
		new JdbcTest07().myMember();
		
		

	}
	private void selectAll(){
		try {
			conn = DBUtil.getConnection();
			
			String sql = "select * from mymember";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				System.out.println();
				System.out.println("MEM_ID : " + rs.getString("MEM_ID"));
				System.out.println("MEM_NAME : " + rs.getString("MEM_NAME"));
				System.out.println("MEM_TEL : " + rs.getString("MEM_TEL"));
				System.out.println("MEM_ADDR : " + rs.getString("MEM_ADDR"));
				System.out.println("------------------------------");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	/*private void update(){
		try {
			conn = DBUtil.getConnection();
			
			String memId;
			int count = 0;
		
			do{
				System.out.print("수정할 멤버 아이디 입력> ");
				memId = scan.next();
			
				String sql1 = "select count(*) cnt from MYMEMBER where MEM_ID = ?";
				pstmt = conn.prepareStatement(sql1);
				pstmt.setString(1, memId);
			
				rs = pstmt.executeQuery();
			
				if(rs.next()){
					count = rs.getInt("cnt");
				}
				if(count < 1){
					System.out.println("입력한 아이디  " +  memId + "는 없는 아이디입니다.");
					System.out.println("다시 입력하세요");
				}
			
			}while(count < 1);
			
			
			System.out.println("이   름 : ");
			String memName = scan.next();
		
			System.out.println("전화번호 : ");
			String memTel = scan.next();

			System.out.println("주소 : ");
			String memAddr = scan.next();
			
			String sql2 = "UPDATE MYMEMBER SET MEM_NAME=?, MEM_TEL=?, MEM_ADDR=? where MEM_ID=?";
			
			pstmt = conn.prepareStatement(sql2);
			
			pstmt.setString(1, memName);
			pstmt.setString(2, memTel);
			pstmt.setString(3, memAddr);
			pstmt.setString(4, memId);
		
			int cnt = pstmt.executeUpdate();
		
			if(cnt>0){
				System.out.println("자료 수정 성공");
			}else{
				System.out.println("자료 수정 실패");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
	
	
	private void delete() {
		try {
			conn = DBUtil.getConnection();
			
			System.out.print("삭제할 멤버 아이디 입력> ");
			String memId = scan.next();
			
			String sql = "DELETE FROM MYMEMBER WHERE MEM_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0){
				System.out.println("아이디 : " + memId + " 자료 삭제 성공");
			}else{
				System.out.println("아이디 : " + memId+" 자료 삭제 실패");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	private void insert() {
		try {
			
			conn = DBUtil.getConnection();
		
			String memId;
			int count = 0;
		
			do{
				System.out.println("멤버 정보 추가하기");
				System.out.println("아 이 디 : ");
				memId = scan.next();
			
				String sql1 = "select count(*) cnt from MYMEMBER where MEM_ID = ?";
				pstmt = conn.prepareStatement(sql1);
				pstmt.setString(1, memId);
			
				rs = pstmt.executeQuery();
			
				if(rs.next()){
					count = rs.getInt("cnt");
				}
				if(count == 1){
					System.out.println("입력한 아이디  " +  memId + "는 이미 등록된 아이디입니다.");
					System.out.println("다시 입력하세요");
				}
			
			}while(count == 1);
		
		
			System.out.println("이   름 : ");
			String memName = scan.next();
		
			System.out.println("전화번호 : ");
			String memTel = scan.next();

			System.out.println("주소 : ");
			String memAddr = scan.next();
		
			String sql2 = "insert into MYMEMBER (MEM_ID, MEM_NAME, MEM_TEL, MEM_ADDR) values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, memId);
			pstmt.setString(2, memName);
			pstmt.setString(3, memTel);
			pstmt.setString(4, memAddr);
		
			int cnt = pstmt.executeUpdate();
		
			if(cnt>0){
				System.out.println("등록 성공");
			}else{
				System.out.println("등록실패");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
	
	private void myMember(){
		
		while(true){
			int choice = menu();
			switch(choice){
			case 1:      // 자료 추가
	            insert();
	            break;
	        case 2:      // 자료 삭제
	        	delete();
	            break;
	        /*case 3:  
	        	update(); // 자료 수정
	            break;*/
	        case 4:
	        	selectAll();// 전체 자료 출력
	        	 break;
	        case 0:
	        	 System.out.println("작업 끝");
				 System.exit(0);
				 break;
				default :  System.out.println("번호 다시 입력"); 
			}
		}
		
	}

	private int menu(){
			System.out.println("--- 작업 선택 ---");
			System.out.println("1. 자료 추가");
	        System.out.println("2. 자료 삭제");
	        System.out.println("3. 자료 수정");
	        System.out.println("4. 전체 자료 출력");
	        System.out.println("0. 작업 끝");
	        System.out.println("------------");
	        System.out.print("작업 선택>> ");
	        int num = scan.nextInt();
	      
	        return num;
	}
	
}

















