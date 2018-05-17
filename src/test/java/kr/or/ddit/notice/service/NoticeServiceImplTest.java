package kr.or.ddit.notice.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.notice.model.NoticeVO;

import org.junit.Test;

public class NoticeServiceImplTest {
	private NoticeServiceInf service = NoticeServiceImpl.getInstance();
	@Test
	public void test() {
		/***Given***/
		

		/***When***/
		List<NoticeVO>noticeList = service.getNotice();
		
		/***Then***/
		assertEquals(2, noticeList.size());
		assertEquals("자유게시판", noticeList.get(0).getNo_name());
	}
	
	@Test
	public void insertNotice(){
		/***Given***/
		

		/***When***/
		
		
		int cnt = service.insertNotice(new NoticeVO("sally","출석게시판","Y"));
		List<NoticeVO> list = service.getNotice();
		/***Then***/
		assertEquals(1, cnt);
		assertEquals(5, list.size());
	}

}
