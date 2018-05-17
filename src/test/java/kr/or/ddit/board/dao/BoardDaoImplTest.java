package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVO;

import org.junit.Test;

public class BoardDaoImplTest {
	BoardDaoInf dao = BoardDaoImpl.getInstance();
	@Test
	public void boardPageListTest() {
		/***Given***/
		

		/***When***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", 1);
		map.put("pageSize", 10);
		map.put("category_seq", 1);
		
		List<BoardVO> list = dao.boardPageList(map);
		/***Then***/
		assertNotNull(list);
		System.out.println(list);
		assertEquals(10, list.size());
		assertEquals(1, (int)list.get(0).getCategory_seq());

	}
	
	@Test
	public void totalBoard(){
		/***Given***/
		

		/***When***/
		int cnt = dao.totalBoard();
		
		/***Then***/
		assertEquals(22, cnt);
	}
	
	@Test
	public void getNoticeNameTest(){
		/***Given***/
		

		/***When***/
		String name = dao.getNoticeName(1);
		/***Then***/
		assertEquals("자유게시판", name);

	}
	
	@Test
	public void boardModifyTest(){
		/***Given***/
		

		/***When***/
		BoardVO vo = new BoardVO();
		vo.setTitle("수정 테스트");
		vo.setCategory_seq(3);
		vo.setContent("수정");
		vo.setBoard_seq(1);
		
		int cnt = dao.boardModify(vo);
		
		BoardVO result = dao.getBoard(1);
		/***Then***/
		assertEquals(1, cnt);
		assertEquals("수정 테스트", result.getTitle());

	}
	
	@Test
	public void selectNoticeBoardTest(){
		/***Given***/
		

		/***When***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", 1);
		map.put("pageSize", 10);
		map.put("category_seq", 1);
		
		List<BoardVO> list = dao.selectNoticeBoard(map);
		/***Then***/
		assertNotNull(list);
		System.out.println(list);
		assertEquals(8, list.size());
		assertEquals(1, (int)list.get(0).getCategory_seq());

	}

}
