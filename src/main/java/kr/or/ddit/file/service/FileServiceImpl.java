package kr.or.ddit.file.service;

import java.util.Map;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.BoardServiceInf;

public class FileServiceImpl implements FileServiceInf{
	private static FileServiceInf service = new FileServiceImpl();
	private BoardDaoInf dao;
	
	private FileServiceImpl(){
		dao = BoardDaoImpl.getInstance();
	}
	
	public static FileServiceInf getInstance() {
		return service;
	}
	@Override
	public int insetFile(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

}
