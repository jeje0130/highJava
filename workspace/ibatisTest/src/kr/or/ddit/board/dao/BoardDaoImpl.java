package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapUtil;
import kr.or.ddit.vo.BoardVO;

public class BoardDaoImpl implements BoardDao {
	
	private SqlMapClient smc;
	
	private static BoardDaoImpl dao;
	
	private BoardDaoImpl() {
		smc = SqlMapUtil.getSqlMapClient();
	}
	
	public static BoardDaoImpl getInstance() {
		if(dao==null) {
			dao = new BoardDaoImpl();
		}
		return dao;
	}
	

	@Override
	public int insertBoard(BoardVO BoardVo) {
		int cnt = 0;
		try {
			
			Object obj = smc.insert("board.insertBoard", BoardVo);
			if(obj == null) cnt = 1;
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} 
		return cnt;
	}

	
	
	
	@Override
	public int deleteBoard(int boardNo) {
		int cnt = 0;
		try {
			
			cnt = smc.delete("board.deleteBoard", boardNo);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} 
		return cnt;
	}
	
	

	@Override
	public int updateBoard(BoardVO BoardVo) {
		int cnt = 0;
		try {
			
			cnt = smc.update("board.updateBoard", BoardVo);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} 
		return cnt;
	}

	
	
	@Override
	public BoardVO getBoard(int boardNo) {
		BoardVO BoardVo = null;
		
		// 조회수를 1 증가시킨다.
		if(setCountIncrement(boardNo)==0) {
			return null;
		}
		
		try {
			
			BoardVo = (BoardVO) smc.queryForList("board.getBoard", boardNo);
			
		} catch (SQLException e) {
			BoardVo = null;
			e.printStackTrace();
		} 
		
		return BoardVo;
	}

	
	
	
	@Override
	public List<BoardVO> getAllBoardList() {
		ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			
			boardList = (ArrayList<BoardVO>) smc.queryForList("board.getAllBoardList");
			
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		} 
		
		return boardList;
	}

	
	
	
	
	
	@Override
	public List<BoardVO> getSearchBoardList(String BoardTitle) {
		ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();
		if(BoardTitle==null) {
			BoardTitle = "";
		}
		try {
			
			boardList = (ArrayList<BoardVO>) smc.queryForList("board.getSearchBoardList", BoardTitle);
			
			
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		} 
		
		return boardList;
	}
	
	
	
	

	@Override
	public int setCountIncrement(int boardNo) {
		int cnt = 0;
		try {
			
			cnt = smc.update("board.setCountIncrement", boardNo);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} 
		return cnt;
	}

}
