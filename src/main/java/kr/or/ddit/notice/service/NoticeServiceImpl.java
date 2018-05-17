package kr.or.ddit.notice.service;

import java.util.List;

import kr.or.ddit.notice.dao.NoticeDaoImpl;
import kr.or.ddit.notice.dao.NoticeDaoInf;
import kr.or.ddit.notice.model.NoticeVO;

public class NoticeServiceImpl implements NoticeServiceInf{
	private static NoticeServiceInf service = new NoticeServiceImpl();
	private NoticeDaoInf dao;
	
	private NoticeServiceImpl(){
		dao = NoticeDaoImpl.getInstance();
	}
	
	public static NoticeServiceInf getInstance() {
		return service;
	}
	
	@Override
	public List<NoticeVO> getNotice() {
		return dao.getNotice();
	}

	@Override
	public int insertNotice(NoticeVO vo) {
		return dao.insertNotice(vo);
	}

}
