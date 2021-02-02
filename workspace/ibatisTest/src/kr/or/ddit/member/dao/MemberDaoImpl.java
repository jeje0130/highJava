package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapUtil;
import kr.or.ddit.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao{
	
	private SqlMapClient smc;
	
	//singleton만들기
	private static MemberDaoImpl memDao;
	
	//생성자
	private MemberDaoImpl(){
		smc = SqlMapUtil.getSqlMapClient();
	}
	
	public static MemberDaoImpl getInstance(){
		if(memDao==null) memDao = new MemberDaoImpl();
		return memDao;
	}

	@Override
	public int insertMember(MemberVO memVo) {

		int cnt = 0;

		try {

			Object obj = smc.insert("mymember.insertMember", memVo);
			
			if(obj == null) cnt = 1; //insert  성공 여부 판단
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}



	@Override
	public int deleteMember(String memId) {

		int cnt = 0;

		try {
			cnt = smc.delete("mymember.deleteMember", memId);

		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;

	}



	@Override
	public int updateMember(MemberVO memVo) {

		int cnt = 0;

		try {
			cnt = smc.update("mymember.updateMember", memVo);

		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}




	@Override
	public List<MemberVO> getAllMember() {
		
		List<MemberVO> memList = null;

		try {
			memList = smc.queryForList("mymember.getAllMember");
			
		} catch (SQLException e) {
			memList = null;
		}
		return memList;
}




	@Override
	public int getMemberCount(String memId) {

		int count = 0;

		try {
			count = (int) smc.queryForObject("mymember.getMemberCount", memId);

		} catch (SQLException e) {
			count = 0;
			e.printStackTrace();
		}
		return count;
	}



	@Override
	public int updateMember2(Map<String, String> paraMap) {
		// key값 => 회원ID(memId), 수정할 컬럼명(field), 수정할 데이터(data)

		int cnt = 0;

		  try {
			  cnt = smc.update("mymember.updateMember2", paraMap);
		  
		  } catch (SQLException e) { cnt = 0; e.printStackTrace(); }
		 
		return cnt;
	}




}
