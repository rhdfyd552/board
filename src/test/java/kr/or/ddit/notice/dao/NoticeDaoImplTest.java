package kr.or.ddit.notice.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.notice.model.NoticeVO;

import org.junit.Test;

public class NoticeDaoImplTest {
	NoticeDaoInf dao = NoticeDaoImpl.getInstance();
	@Test
	public void getNoticeTest() {
		/***Given***/
		

		/***When***/
		List<NoticeVO>noticeList = dao.getNotice();
		
		
		/***Then***/
		assertEquals(1, noticeList.size());
		assertEquals("잡담게시판", noticeList.get(0).getNo_name());
	}
	
	@Test
	public void insertNotice(){
		/***Given***/
		

		/***When***/
		
		
		int cnt = dao.insertNotice(new NoticeVO("brown","후기게시판","Y"));
		List<NoticeVO> list = dao.getNotice();
		/***Then***/
		assertEquals(1, cnt);
		assertEquals(2, list.size());

	}
	
	@Test
	public void updaetNotice(){
		/***Given***/
		

		/***When***/
		NoticeVO vo = new NoticeVO();
		vo.setNo_st("N");
		vo.setNo_seq(1);
		
		int cnt = dao.updaetNotice(vo);
		List<NoticeVO> list = dao.getNotice();
		/***Then***/
		assertEquals(1, cnt);
		assertEquals("N", list.get(0).getNo_st());

	}
}
