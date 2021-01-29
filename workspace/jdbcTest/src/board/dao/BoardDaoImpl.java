package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.util.DBUtil3;
import board.vo.BoardVO;

public class BoardDaoImpl  implements IBoardDao{

	@Override
	public int insertBoard(BoardVO boardVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int cnt = 0;

		try {
			conn = DBUtil3.getConnection();

			String sql = "insert into JDBC_BOARD (BOARD_NO, BOARD_TITLE, BOARD_WRITER, "
					+ " BOARD_DATE, BOARD_CNT, BOARD_CONTENT) values(board_seq.nextval, ?, ?, sysdate, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVo.getBoard_title());
			pstmt.setString(2, boardVo.getBoard_title());
			pstmt.setString(3, boardVo.getBoard_writer());
			pstmt.setString(5, boardVo.getBoard_title());
			

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
	public int deleteBoard(int boardNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBoard(BoardVO boardVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVO> getAllBoard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getBoardCount(int boardNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
