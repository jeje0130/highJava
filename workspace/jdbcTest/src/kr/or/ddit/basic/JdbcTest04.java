package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 	문제) 사용자로부터 시, 군, 구 중 한가지를 입력 받아 DB의 Member테이블에서
 		회원의 주소에 입력한 값이 포함되는 데이터를 모두 출력하시오.
 */

public class JdbcTest04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("주소의 일부분을(시, 군, 구, 동) 입력>");
		String add = scan.nextLine();

		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; 
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "YJH01", "java");
			
			String sql = "select * from member where MEM_ADD1 LIKE '%" + add + "%'";
			
			stmt = conn.createStatement();
			
			
			rs = stmt.executeQuery(sql);
			
			
			
			System.out.println();
			System.out.println("-----------------쿼리문 처리 결과----------------");
			
			while(rs.next()){
				System.out.println("MEM_ID : " + rs.getString("MEM_ID"));
				System.out.println("MEM_NAME : " + rs.getString("MEM_NAME"));
				System.out.println("MEM_ZIP : " + rs.getString("MEM_ZIP"));
				System.out.println("MEM_REGNO : " + rs.getString("MEM_ADD1") + " "+ rs.getString("MEM_ADD2"));
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
