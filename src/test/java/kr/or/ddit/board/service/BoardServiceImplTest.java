package kr.or.ddit.board.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVO;

import org.junit.Test;

public class BoardServiceImplTest {
	private BoardServiceInf service = BoardServiceImpl.getInstance();
	
	
	@Test
	public void boardPageListTets() {
		/***Given***/
		
		/***When***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", 1);
		map.put("pageSize", 10);
		
		Map<String,Object> list = service.boardPageList(map);
		/***Then***/
		assertNotNull(list);
		System.out.println(list);
		assertEquals(10, list.size());
	}
	@Test
	public void getNoticeNameTest(){
		/***Given***/
		

		/***When***/
		String name = service.getNoticeName(1);
		/***Then***/
		assertEquals("자유게시판", name);

	}
	
	@Test
	public void boardModifyTest(){
		/***Given***/
		

		/***When***/
		BoardVO vo = new BoardVO();
		vo.setTitle("수정 완료");
		vo.setCategory_seq(3);
		vo.setContent("수정");
		vo.setBoard_seq(1);
		
		int cnt = service.boardModify(vo);
		
		BoardVO result = service.getBoard(1);
		/***Then***/
		assertEquals(1, cnt);
		assertEquals("수정 완료", result.getTitle());

	}
	
	@Test
	public void selectNoticeBoardTest(){
		/***Given***/
		

		/***When***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", 1);
		map.put("pageSize", 10);
		map.put("category_seq", 1);
		
		Map<String, Object> list =  service.selectNoticeBoard(map);
		/***Then***/
		assertNotNull(list);
		assertEquals(2, list.size());
	}
}
