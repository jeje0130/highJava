package kr.or.ddit.basic.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import kr.or.ddit.basic.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtil3;

public class MemberDaoImpl implements IMemberDao{
	private static final Logger logger = Logger.getLogger(MemberDaoImpl.class);
	
	//singleton만들기
	private static MemberDaoImpl memDao;
	
	//생성자
	private MemberDaoImpl(){}
	
	public static MemberDaoImpl getInstance(){
		if(memDao==null) memDao = new MemberDaoImpl();
		return memDao;
	}

	@Override
	public int insertMember(MemberVO memVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int cnt = 0;

		try {
			conn = DBUtil3.getConnection();
			logger.info("---Connection 객체 생성 완료---");

			String sql = "insert into MYMEMBER (MEM_ID, MEM_NAME, MEM_TEL, MEM_ADDR) values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVo.getMem_id());
			pstmt.setString(2, memVo.getMem_name());
			pstmt.setString(3, memVo.getMem_tel());
			pstmt.setString(4, memVo.getMem_addr());
			
			logger.info("---prepareStatement 객체 생성---");
			logger.info("실행 SQL문 : " + sql);
			logger.info("사용 데이터 : [" + memVo.getMem_id() + ", " + memVo.getMem_name() + ", " 
						+ memVo.getMem_tel() + ", " + memVo.getMem_addr() + "]");
			

			cnt = pstmt.executeUpdate();
			logger.info("---작업 성공---");

		} catch (SQLException e) {
			logger.error("---작업 실패---");
			cnt = 0;
			e.printStackTrace();
		}finally{
			if(pstmt!=null) try{
				pstmt.close();
				logger.info("---prepareStatement 객체 반납---");
				
			}catch (SQLException e2) {	}
			if(conn!=null) try{
				conn.close();
				logger.info("---Connection 객체 반납---");
				
			}catch (SQLException e2) {	}
		}
		return cnt;
	}



	@Override
	public int deleteMember(String memId) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int cnt = 0;

		try {
			conn = DBUtil3.getConnection();
			logger.info("---Connection 객체 생성 완료---");

			String sql = "DELETE FROM MYMEMBER WHERE MEM_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			logger.info("---prepareStatement 객체 생성---");
			logger.info("실행 SQL문 : " + sql);

			cnt = pstmt.executeUpdate();
			logger.info("---작업 성공---");

		} catch (SQLException e) {
			logger.error("---작업 실패---");
			cnt = 0;
			e.printStackTrace();
		}finally{
			if(pstmt!=null) try{
				pstmt.close();
				logger.info("---prepareStatement 객체 반납---");
				}catch (SQLException e2) {	}
			
			if(conn!=null) try{
				conn.close();
				logger.info("---Connection 객체 반납---");
				}catch (SQLException e2) {	}
		}
		return cnt;

	}



	@Override
	public int updateMember(MemberVO memVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int cnt = 0;

		try {
			conn = DBUtil3.getConnection();
			logger.info("---Connection 객체 생성 완료---");

			String sql = "UPDATE MYMEMBER SET MEM_NAME = ? , MEM_TEL = ? , MEM_ADDR = ? where MEM_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVo.getMem_name());
			pstmt.setString(2, memVo.getMem_tel());
			pstmt.setString(3, memVo.getMem_addr());
			pstmt.setString(4, memVo.getMem_id());
			
			logger.info("---prepareStatement 객체 생성---");
			logger.info("실행 SQL문 : " + sql);
			logger.info("사용 데이터 : [" + memVo.getMem_id() + ", " + memVo.getMem_name() + ", " 
						+ memVo.getMem_tel() + ", " + memVo.getMem_addr() + "]");

			cnt = pstmt.executeUpdate();
			logger.info("---작업 성공---");

		} catch (SQLException e) {
			logger.error("---작업 실패---");
			cnt = 0;
			e.printStackTrace();
		}finally{
			if(pstmt!=null) try{
				pstmt.close();
				logger.info("---prepareStatement 객체 반납---");
				}catch (SQLException e2) {	}
			
			if(conn!=null) try{
				conn.close();
				logger.info("---Connection 객체 반납---");
				}catch (SQLException e2) {	}
		}
		return cnt;
	}




	@Override
	public List<MemberVO> getAllMember() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<MemberVO> memList = new ArrayList<>();

		try {
			conn = DBUtil3.getConnection();
			logger.info("---Connection 객체 생성 완료---");

			String sql = "select * from mymember";
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while(rs.next()){
				MemberVO memVo = new MemberVO();
				memVo.setMem_id(rs.getString("mem_id"));
				memVo.setMem_name(rs.getString("mem_name"));
				memVo.setMem_tel(rs.getString("mem_tel"));
				memVo.setMem_addr(rs.getString("mem_addr"));

				memList.add(memVo);
				logger.info("---작업 성공---");
			}
		} catch (SQLException e) {
			logger.error("---작업 실패---");
			memList = null;
		}finally{
			if(rs!=null) try{
				rs.close();
				logger.info("---ResultSet 객체 반납---");
				}catch (SQLException e2) {	}
			if(stmt!=null) try
			{stmt.close();
			logger.info("---Statement 객체 반납---");
			}catch (SQLException e2) {	}
			if(conn!=null) try{
				conn.close();
				logger.info("---Connection 객체 반납---");
				}catch (SQLException e2) {	}
		}
		return memList;
	}




	@Override
	public int getMemberCount(String memId) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		int cnt = 0;

		try {
			conn = DBUtil3.getConnection();
			logger.info("---Connection 객체 생성 완료---");

			String sql = "select count(*) cnt from MYMEMBER where MEM_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				cnt = rs.getInt("cnt");
			}
			logger.info("---작업 성공---");


		} catch (SQLException e) {
			logger.error("---작업 실패---");
			cnt = 0;
			e.printStackTrace();
		}finally{
			if(rs!=null) try{
				rs.close();
				logger.info("---ResultSet 객체 반납---");
			}catch (SQLException e2) {	}
			if(pstmt!=null) try{
				pstmt.close();
				logger.info("---prepareStatement 객체 반납---");
				}catch (SQLException e2) {	}
			if(conn!=null) try{
				conn.close();
				logger.info("---Connection 객체 반납---");
				}catch (SQLException e2) {	}
		}
		return cnt;
	}



	@Override
	public int updateMember2(Map<String, String> paraMap) {
		// key값 => 회원ID(memId), 수정할 컬럼명(field), 수정할 데이터(data)
		Connection conn = null;
		PreparedStatement pstmt = null;

		int cnt = 0;

		try {
			conn = DBUtil3.getConnection();
			logger.info("---Connection 객체 생성 완료---");

			String sql = "UPDATE MYMEMBER SET " + paraMap.get("field")  + " = ? " + " where MEM_ID = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paraMap.get("data"));
			pstmt.setString(2, paraMap.get("memId"));

			cnt = pstmt.executeUpdate();
			logger.info("---작업 성공---");

		} catch (SQLException e) {
			logger.error("---작업 실패---");
			cnt = 0;
			e.printStackTrace();
		}finally{
			if(pstmt!=null) try{
				pstmt.close();
				logger.info("---prepareStatement 객체 반납---");
				}catch (SQLException e2) {	}
			if(conn!=null) try{
				conn.close();
				logger.info("---Connection 객체 반납---");
				}catch (SQLException e2) {	}
		}
		return cnt;
	}




}
