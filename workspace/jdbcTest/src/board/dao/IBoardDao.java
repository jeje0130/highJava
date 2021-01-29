package board.dao;

import java.util.List;

import board.vo.BoardVO;

public interface IBoardDao {

	public int insertBoard(BoardVO boardVo);
	
	public int deleteBoard(int boardNo);
	
	public int updateBoard(BoardVO boardVo);
	
	public List<BoardVO> getAllBoard();
	
	public int getBoardCount(int boardNo);
}
