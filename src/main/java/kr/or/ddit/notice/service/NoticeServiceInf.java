package kr.or.ddit.notice.service;

import java.util.List;

import kr.or.ddit.notice.model.NoticeVO;

public interface NoticeServiceInf {
	public List<NoticeVO> getNotice();
	
	public int insertNotice(NoticeVO vo);
}
