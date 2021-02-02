package kr.or.ddit.board.service;

import java.util.List;
import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.vo.BoardVO;

public class BoardServiceImpl implements BoardService {
	private BoardDao dao;
	private static BoardServiceImpl service;
	
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getInstance();
	}
	
	public static BoardServiceImpl getInstance() {
		if(service==null) {
			service = new BoardServiceImpl();
		}
		return service;
	}

	@Override
	public int insertBoard(BoardVO BoardVo) {
		return dao.insertBoard(BoardVo);
	}

	@Override
	public int deleteBoard(int boardNo) {
		return dao.deleteBoard(boardNo);
	}

	@Override
	public int updateBoard(BoardVO BoardVo) {
		return dao.updateBoard(BoardVo);
	}

	@Override
	public BoardVO getBoard(int boardNo) {
		return dao.getBoard(boardNo);
	}

	@Override
	public List<BoardVO> getAllBoardList() {
		return dao.getAllBoardList();
	}

	@Override
	public List<BoardVO> getSearchBoardList(String BoardTitle) {
		return dao.getSearchBoardList(BoardTitle);
	}

	@Override
	public int setCountIncrement(int boardNo) {
		return dao.setCountIncrement(boardNo);
	}
}
