package kr.or.ddit.notice.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.notice.model.NoticeVO;

public interface NoticeDaoInf {
	public List<NoticeVO> getNotice();
	
	public int insertNotice(NoticeVO vo);
	
	public int updaetNotice(NoticeVO vo);
}
