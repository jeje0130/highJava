package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.util.SqlMapUtil;

/*
 * jdbcTest 프로젝트에 있는 'JdbcTest06.java'의 처리방법을
 * ibatis를 이용하여 처리하는 것으로 변경하시오
 * 
 * 쿼리문이 저장될 xml문서 이름은 'jdbc06.xml'로 한다.
 * 
 * 
 * LPROD테이블에 새로운 데이터를 추가하시오
 * 
 * 조건) LPROD_GU와 LPROD_NM은 직접 입력받아서 처리하고,
 * 		LPROD_ID는 현재의 LPROD_ID중 제일 큰 값보다 1증가된 값으로 한다.
 * 		그리고, 입력받은 LPROD_GU가 이미 등록되어있으면 다시 입력받아서 처리한다.
 */

public class JdbcTest06ToIbatis {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		SqlMapClient smc = null; //SQL문을 처리할 SqlMapClient객체 변수 선언
		//Reader rd = null;
		
		try {
			/*
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);

			rd = Resources.getResourceAsReader("sqlMapConfig.xml");

			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			*/
			
			smc = SqlMapUtil.getSqlMapClient();
			
			//---------------------------------------------------------
			
			//다음 순번의 lprod_id값 구하기
			int lprodId = (int)smc.queryForObject("jdbc06.getMaxId");
			
			
			String lprodGu; //상품분류코드가 저장될 변수
			int count = 0;  //입력한 상품분류코드의 개수가 저장될 변수
			do{
				System.out.print("상품 분류 코드 입력 : ");
				lprodGu = scan.next();
				
				count = (int) smc.queryForObject("jdbc06.getLprodCount", lprodGu);
				
				if(count == 1){
					System.out.println("입력한 상품분류코드  " +  lprodGu + "는 이미 등록된 코드입니다.");
					System.out.println("다시 입력하세요");
				}
				
			}while(count>0);
			
			System.out.print("상품 분류명 입력 : ");
			String lprodNm = scan.next();
			
			LprodVO lvo = new LprodVO();
			lvo.setLprod_id(lprodId);
			lvo.setLprod_gu(lprodGu);
			lvo.setLprod_nm(lprodNm);
			
			Object obj = smc.insert("jdbc06.insertLprod", lvo);
			
			if(obj==null) {
				System.out.println("추가 성공!!!");
			}else {
				System.out.println("추가 실패!!!");
			}

	//	}catch (IOException e) {
	//		e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		//}finally {
	//		if(rd != null) try {rd.close();} catch (Exception e2) {}
		}

	}

}
