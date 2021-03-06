package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.DBUtil2;
import kr.or.ddit.util.DBUtil3;

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
			case 3:  
	        	update(); // 자료 수정
	            break;
			case 4:
				update2();
				break;
			case 5:
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
		System.out.println("4. 자료 일부 수정");
		System.out.println("5. 전체 자료 출력");
		System.out.println("0. 작업 끝");
		System.out.println("------------");
		System.out.print("작업 선택>> ");
		int num = scan.nextInt();
		
		return num;
	}
	
	
	
	
	private void selectAll(){

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println("ID	이름	전화번호		주소");
		System.out.println("---------------------------------------");

		try {
			conn = DBUtil.getConnection();
			
			String sql = "select * from mymember";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String memId = rs.getString("MEM_ID");
				String memName = rs.getString("MEM_NAME");
				String memTel = rs.getString("MEM_TEL");
				String memAddr = rs.getString("MEM_ADDR");
				System.out.println(memId + "\t" + memName + "\t" + memTel + "\t" + memAddr);
			}
			System.out.println("---------------------------------------");
			System.out.println("출력끝");
			System.out.println();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs!=null) try{rs.close();}catch (SQLException e2) {	}
			if(stmt!=null) try{stmt.close();}catch (SQLException e2) {	}
			if(conn!=null) try{conn.close();}catch (SQLException e2) {	}
		}
		
	}
	
	//원하는 컬럼만 수정
	private void update2(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.println();
		System.out.print("수정할 회원 아이디 입력> ");
		String memId = scan.next();
		
		int count = getMemberCount(memId);
		if(count == 0){ //없는회원이면
			System.out.println("입력한 아이디  " +  memId + "는 없는 회원아이디입니다.");
			System.out.println("수정 작업 끝");
			return;
		}
		
		int num;
		String updateField = null; // 수정할 컬럼명이 저장될 변수
		String updatestr = null; // 수정할 컬럼의 한글명이 저장될 변수
		
		do{
			System.out.println();
			System.out.println("수정할 항목을 선택");
			System.out.println("1.회원이름	2.전화번호	3.회원주소");
			System.out.println("---------------------------------------");
			System.out.println("수정 항목 입력>>");
			num = scan.nextInt();
			
			switch(num){
			case 1:
				updateField = "mem_name";
				updatestr = "회원이름";
				break;
			case 2:
				updateField = "mem_tel";
				updatestr = "전화번호";
				break;
			case 3:
				updateField = "mem_addr";
				updatestr = "회원주소";
				break;
			default :
				System.out.println("수정 항목을 잘못 입력했습니다");
				System.out.println("다시 입력해주세요");
			}
			
		}while(num<1 || num>3);
		
		scan.nextLine();
		System.out.print("새로운 " + updatestr + ">>");
		String updateData = scan.nextLine();
		
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "UPDATE MYMEMBER SET " + updateField  + " = ? " + " where MEM_ID = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, updateData);
			pstmt.setString(2, memId);
		
			int cnt = pstmt.executeUpdate();
		
			if(cnt>0){
				System.out.println("자료 수정 성공");
			}else{
				System.out.println("자료 수정 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(pstmt!=null) try{pstmt.close();}catch (SQLException e2) {}
			if(conn!=null) try{conn.close();}catch (SQLException e2) {}
		}
		
		
	}
	
	
	private void update(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.println();
		System.out.print("수정할 회원 아이디 입력> ");
		String memId = scan.next();
		
		int count = getMemberCount(memId);
		if(count == 0){ //없는회원이면
			System.out.println("입력한 아이디  " +  memId + "는 없는 회원아이디입니다.");
			System.out.println("수정 작업 끝");
			return;
		}
		
		System.out.println("새로운 이름 : ");
		String memName = scan.next();
		
		System.out.println("새로운 전화번호 : ");
		String memTel = scan.next();
		
		scan.nextLine();
		System.out.println("새로운 주소 : ");
		String memAddr = scan.nextLine();
		
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "UPDATE MYMEMBER SET MEM_NAME = ? , MEM_TEL = ? , MEM_ADDR = ? where MEM_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			
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
		}finally{
			if(pstmt!=null) try{pstmt.close();}catch (SQLException e2) {	}
			if(conn!=null) try{conn.close();}catch (SQLException e2) {	}
		}
	}
	
	
	
	private void delete() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.println();
		System.out.print("삭제할 회원 아이디 입력> ");
		String memId = scan.next();
		
		
		try {
			//conn = DBUtil.getConnection();
			//conn = DBUtil2.getConnection();
			conn = DBUtil3.getConnection();
			
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
		}finally{
			if(pstmt!=null) try{pstmt.close();}catch (SQLException e2) {	}
			if(conn!=null) try{conn.close();}catch (SQLException e2) {	}
		}
		
		
	}
	
	
	
	
	
	private void insert() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.println();
		System.out.println("멤버 정보 추가하기");
			
		int count =0;
		String memId;
		do{
			System.out.println("아 이 디 >> ");
			memId = scan.next();
			
			count = getMemberCount(memId);
			
			if(count > 1){
				System.out.println("입력한 아이디  " +  memId + "는 이미 등록된 아이디입니다.");
				System.out.println("다시 입력하세요");
			}
		}while(count>0);
		
			
			System.out.println("이   름 : ");
			String memName = scan.next();
		
			System.out.println("전화번호 : ");
			String memTel = scan.next();
			
			scan.nextLine(); //입력한 버퍼 비우기
			System.out.println("주소 : ");
			String memAddr = scan.nextLine();
			
		try {
			conn = DBUtil.getConnection();
		
			String sql = "insert into MYMEMBER (MEM_ID, MEM_NAME, MEM_TEL, MEM_ADDR) values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			pstmt.setString(2, memName);
			pstmt.setString(3, memTel);
			pstmt.setString(4, memAddr);
		
			int cnt = pstmt.executeUpdate();
		
			if(cnt>0){
				System.out.println(memId + "회원 등록 성공");
			}else{
				System.out.println(memId + "회원 등록 실패");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				if(pstmt!=null) try{pstmt.close();}catch (SQLException e2) {	}
				if(conn!=null) try{conn.close();}catch (SQLException e2) {	}
			}
	}
	
	
	private int getMemberCount(String memId){
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		int count = 0;
		
		try {
			
			conn = DBUtil.getConnection();
			
			String sql = "select count(*) cnt from MYMEMBER where MEM_ID = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				count = rs.getInt("cnt");
			}
			
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		}finally{
			if(rs!=null) try{rs.close();}catch (SQLException e2) {	}
			if(pstmt!=null) try{pstmt.close();}catch (SQLException e2) {	}
			if(conn!=null) try{conn.close();}catch (SQLException e2) {	}
		}
		return count;
	}
	
	
	
}

















