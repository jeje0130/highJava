package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 문제1) 사용자로부터 Lprod_id값을 입력받아 입력한 값보다 
//		lprod_id가 큰 자료들을 출력하시오

// 문제2) lprod_id값을 2개 입력받아 두 값중 작은 값부터 큰 값 사이의 자료들을 출력하시오.

public class JdbcTest02 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; 
		Scanner scan = new Scanner(System.in);
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "YJH01", "java");
			
			System.out.println("lprod_id 입력>");
			String id = scan.nextLine();
			
			String sql = "select * from lprod where lprod_id >" + id;
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			System.out.println("실행한 SQL문 : " + sql);
			System.out.println();
			System.out.println("-----------------쿼리문 처리 결과----------------");
			
			while(rs.next()){
				System.out.println("Lprod_id : " + rs.getInt("lprod_id"));
				System.out.println("Lprod_gu : " + rs.getString("lprod_gu"));
				System.out.println("Lprod_nm : " + rs.getString("LPROD_NM"));
				System.out.println("-------------------------------------------");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//5. 자원 반납하기
			if(rs!=null) try{rs.close();}catch (SQLException e2) {	}
			if(stmt!=null) try{stmt.close();}catch (SQLException e2) {	}
			if(conn!=null) try{conn.close();}catch (SQLException e2) {	}
		}

	}

}
