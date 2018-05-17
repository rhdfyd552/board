package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVO;

public class BoardServiceImpl implements BoardServiceInf{
	private static BoardServiceInf service = new BoardServiceImpl();
	private BoardDaoInf dao;
	
	private BoardServiceImpl(){
		dao = BoardDaoImpl.getInstance();
	}
	
	public static BoardServiceInf getInstance() {
		return service;
	}

	@Override
	public Map<String,Object> boardPageList(Map<String, Integer> map) {
		Map<String, Object>resultMap = new HashMap<String, Object>();
		
		List<BoardVO>boardList = dao.boardPageList(map);
		String pageNav = makePageNav(map.get("page"),dao.totalBoard());
		
		resultMap.put("boardList", boardList);
		resultMap.put("pageNav", pageNav);
		
		return resultMap;
	}
	
	@Override
	public BoardVO getBoard(int board_seq) {
		return dao.getBoard(board_seq);
	}

	@Override
	public String getNoticeName(int category_seq) {
		return dao.getNoticeName(category_seq);
	}
	
	@Override
	public int boardModify(Map<String, Object>map) {
		
		return dao.boardModify(map);
	}
	
	@Override
	public int deleteBoard(int board_seq) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public Map<String, Object> selectNoticeBoard(Map<String, Integer> map) {
		Map<String, Object>resultMap = new HashMap<String, Object>();
		
		List<BoardVO>boardList = dao.selectNoticeBoard(map);
		String pageNav = makePageNav(map.get("page"),dao.totalBoard());
		
		resultMap.put("boardList", boardList);
		resultMap.put("pageNav", pageNav);
		
		return resultMap;
	}
	
	private String makePageNav(int page, int totalBoard) {
		StringBuffer pageNav = new StringBuffer();
		
		int pageTotal = (int)Math.ceil((double)totalBoard/10);
		pageNav.append("<nav id='nav'>");
		pageNav.append("	<ul class='pagination'>");
		pageNav.append("		<li>");
		if(page>1 || page-1>0){
				pageNav.append("<a href='mainBoardList?page=1&pageSize=10' aria-label='Previous'>");
				pageNav.append("<span aria-hidden='true'>&laquo;</span></a></li>");
				pageNav.append("<li><a href='mainBoardList?page="+(page-1)+"&pageSize=10' aria-label='Previous'>");
				pageNav.append("<span aria-hidden='true'>&lt;</span>");
		}else{
			pageNav.append("<a href='#' aria-label='Previous'>");
			pageNav.append("<span aria-hidden='true'>&laquo;</span></a></li>");
			pageNav.append("<li><a href='#' aria-label='Previous'>");
			pageNav.append("<span aria-hidden='true'>&lt;</span>");
		}
		
		pageNav.append("	</a></li>");
		
		for(int i = 1;i<=pageTotal; i++){
			if(i==page){
				pageNav.append("<li class='active'><a href='mainBoardList?page="+i+"&pageSize=10'>"+i+"</a>");
			}else {
				pageNav.append("<li><a href='mainBoardList?page="+i+"&pageSize=10'>"+i+"</a></li>");
			}	
		}
		if(page+1<pageTotal+1 || page != pageTotal){
			pageNav.append("<li><a href='mainBoardList?page="+(page+1)+"&pageSize=10'>");
			pageNav.append("<span aria-hidden='true'>&gt;</span></a></li>");
			pageNav.append("<li><a href='mainBoardList?page="+pageTotal+"&pageSize=10' aria-label='Next'>");
			pageNav.append("<stan aria-hidden='true'>&raquo;</span>");	
		}else{
			pageNav.append("<li><a href='#>");
			pageNav.append("<span aria-hidden='true'>&gt;</span></a></li>");
			pageNav.append("<li><a href='#' aria-label='Next'>");
			pageNav.append("<stan aria-hidden='true'>&raquo;</span>");
		}
		
		pageNav.append("</a></li>");
		pageNav.append("</ul>");
		pageNav.append("</nav>");
		return pageNav.toString();
	}



}
