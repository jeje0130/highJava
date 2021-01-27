package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

// JDBC 드라이버를 로딩하고 Connection객체를 생성하는 메서드로 구성된 Class만들기


//ResourceBundle 객체 이용하기
public class DBUtil3 {
	private static ResourceBundle bundle;
	
	// static 초기화블럭
	static{
		// 객체 생성 및 파일 내용 읽어오기
		bundle = ResourceBundle.getBundle("dbinfo");
		
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName(bundle.getString("driver"));
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("드라이버 로딩 실패");
		}
	}
	
	// DB에 접속하고 접속에 성공하면 Connection객체를 반환하는 메서드
	public static Connection getConnection() {
		try {
			//return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "YJH01", "java");
			return DriverManager.getConnection(bundle.getString("url"),bundle.getString("user"),bundle.getString("pass"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB연결 실패");
			return null;
		}
		
	}
	
}
