package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVO;

public interface BoardDaoInf {
	public List<BoardVO> boardPageList(Map<String, Integer>map);

	public int totalBoard();
	
	public BoardVO getBoard(int board_seq);
	
	public String getNoticeName(int category_seq);
	
	public int boardModify(Map<String, Object>map);
	
	public int deleteBoard(int board_seq);
	
	public List<BoardVO> selectNoticeBoard(Map<String, Integer> map);
	
}
