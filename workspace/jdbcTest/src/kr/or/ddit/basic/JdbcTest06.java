package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

/*
 * LPROD테이블에 새로운 데이터를 추가하시오
 * 
 * 조건) LPROD_GU와 LPROD_NM은 직접 입력받아서 처리하고,
 * 		LPROD_ID는 현재의 LPROD_ID중 제일 큰 값보다 1증가된 값으로 한다.
 * 		그리고, 입력받은 LPROD_GU가 이미 등록되어있으면 다시 입력받아서 처리한다.
 */

public class JdbcTest06 {

	public static void main(String[] args) {
		Scanner scan =  new Scanner(System.in);
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; 
		PreparedStatement pstmt = null;
		
		try {
			
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "YJH01", "java");
			
			conn = DBUtil.getConnection();
			
			//LPROD_ID는 현재의 LPROD_ID중 제일 큰 값보다 1증가된 값으로 설정
			String sql = "select MAX(LPROD_ID)+1 as maxid from LPROD";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			int lprodId = 0;;
			if(rs.next()){
				lprodId = rs.getInt("maxid");
			}
			
			//입력받은 LPROD_GU가 이미 등록되어있으면 다시 입력받아서 처리
			String lprodGu; //상품분류코드가 저장될 변수
			int count = 0;  //입력한 상품분류코드의 개수가 저장될 변수
			do{
				System.out.println("분류코드 : ");
				lprodGu = scan.next();
				
				String sql2 = "select count(*) cnt from lprod where LPROD_GU = ?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, lprodGu);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()){
					count = rs.getInt("cnt");
				}
				if(count == 1){
					System.out.println("입력한 상품분류코드  " +  lprodGu + "는 이미 등록된 코드입니다.");
					System.out.println("다시 입력하세요");
				}
				
			}while(count == 1);
			
			System.out.println("분류명 : ");
			String lprodNm = scan.next();
			
			String sql3 = "insert into lprod (LPROD_ID, LPROD_GU, LPROD_NM) values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql3);
			pstmt.setInt(1, lprodId);
			pstmt.setString(2, lprodGu);
			pstmt.setString(3, lprodNm);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0){
				System.out.println("등록 성공");
			}else{
				System.out.println("등록실패");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		//} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		}

	}

}
