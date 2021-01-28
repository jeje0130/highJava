package kr.or.ddit.basic.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.basic.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.DBUtil3;

public class MemberDaoImpl implements IMemberDao{

	@Override
	public int insertMember(MemberVO memVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "insert into MYMEMBER (MEM_ID, MEM_NAME, MEM_TEL, MEM_ADDR) values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVo.getMem_id());
			pstmt.setString(2, memVo.getMem_name());
			pstmt.setString(3, memVo.getMem_tel());
			pstmt.setString(4, memVo.getMem_addr());
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}finally{
			if(pstmt!=null) try{pstmt.close();}catch (SQLException e2) {	}
			if(conn!=null) try{conn.close();}catch (SQLException e2) {	}
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
			
			String sql = "DELETE FROM MYMEMBER WHERE MEM_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}finally{
			if(pstmt!=null) try{pstmt.close();}catch (SQLException e2) {	}
			if(conn!=null) try{conn.close();}catch (SQLException e2) {	}
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
			
			String sql = "UPDATE MYMEMBER SET MEM_NAME = ? , MEM_TEL = ? , MEM_ADDR = ? where MEM_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVo.getMem_name());
			pstmt.setString(2, memVo.getMem_tel());
			pstmt.setString(3, memVo.getMem_addr());
			pstmt.setString(4, memVo.getMem_id());
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}finally{
			if(pstmt!=null) try{pstmt.close();}catch (SQLException e2) {	}
			if(conn!=null) try{conn.close();}catch (SQLException e2) {	}
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
			}
		} catch (SQLException e) {
			memList = null;
		}finally{
			if(rs!=null) try{rs.close();}catch (SQLException e2) {	}
			if(stmt!=null) try{stmt.close();}catch (SQLException e2) {	}
			if(conn!=null) try{conn.close();}catch (SQLException e2) {	}
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
			
			String sql = "select count(*) cnt from MYMEMBER where MEM_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				cnt = rs.getInt("cnt");
			}
			
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}finally{
			if(rs!=null) try{rs.close();}catch (SQLException e2) {	}
			if(pstmt!=null) try{pstmt.close();}catch (SQLException e2) {	}
			if(conn!=null) try{conn.close();}catch (SQLException e2) {	}
		}
		return cnt;
	}



	@Override
	public int updateMem(MemberVO memvo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();

			String sql = "UPDATE MYMEMBER SET " + updateField  + " = ? " + " where MEM_ID = ?";
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return 0;
	}
}
