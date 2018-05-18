package kr.or.ddit.file.service;

import java.util.Map;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.file.dao.FileDaoImpl;
import kr.or.ddit.file.dao.FileDaoInf;
import kr.or.ddit.file.model.FileVO;

public class FileServiceImpl implements FileServiceInf{
	private static FileServiceInf service = new FileServiceImpl();
	private FileDaoInf dao;
	
	private FileServiceImpl(){
		dao = FileDaoImpl.getInstance();
	}
	
	public static FileServiceInf getInstance() {
		return service;
	}
	@Override
	public int insetFile(FileVO vo) {
		
		return dao.insetFile(vo);
	}

}
