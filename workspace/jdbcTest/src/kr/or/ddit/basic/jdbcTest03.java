package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


//문제2) lprod_id값을 2개 입력받아 두 값중 작은 값부터 큰 값 사이의 자료들을 출력하시오.

public class jdbcTest03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("첫번째 lprod_id 입력>");
		int id1 = scan.nextInt();
		System.out.println("두번째 lprod_id 입력>");
		int id2 = scan.nextInt();
		
		int max, min;
		if(id1 > id2){
			max = id1;
			min = id2;
		}else{
			max = id2;
			min = id1;
		}

		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; 
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "YJH01", "java");
			
			//String sql = "select * from lprod where lprod_id >= " + min + " and lprod_id <= " + max;
			String sql = "select * from lprod where lprod_id between " + min + " and " + max;
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			
			//System.out.println("실행한 SQL문 : " + sql);
			
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
