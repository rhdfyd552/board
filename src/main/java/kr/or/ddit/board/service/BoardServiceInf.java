package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVO;


public interface BoardServiceInf {
	public Map<String,Object> boardPageList(Map<String, Integer>map);

	public BoardVO getBoard(int board_seq);
	
	public String getNoticeName(int category_seq);
	
	public int boardModify(Map<String, Object>map);
	
	public int deleteBoard(int board_seq);
	
	public Map<String, Object> selectNoticeBoard(Map<String, Integer> map);

}
