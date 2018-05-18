package kr.or.ddit.board.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.file.model.FileVO;

public class BoardDaoImpl implements BoardDaoInf{
	
	private static BoardDaoInf dao = new BoardDaoImpl();
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession session;
	
	private BoardDaoImpl() {
		String resource = "db/mybatis/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static BoardDaoInf getInstance() {
		return dao;
	}

	@Override
	public List<BoardVO> boardPageList(Map<String, Integer> map) {
		session = sqlSessionFactory.openSession();
		List<BoardVO> boardList = session.selectList("board.boardPageList",map);
		session.close();
		return boardList;
	}

	@Override
	public int totalBoard() {
		session = sqlSessionFactory.openSession();
		int cnt = session.selectOne("board.totalBoard");
		session.close();
		return cnt;
	}

	@Override
	public BoardVO getBoard(int board_seq) {
		session = sqlSessionFactory.openSession();
		BoardVO vo = session.selectOne("board.getBoard",board_seq);
		session.close();
		return vo;
	}

	@Override
	public String getNoticeName(int category_seq) {
		session = sqlSessionFactory.openSession();
		String categoryName = session.selectOne("board.getNoticeName",category_seq);
		session.close();
		return categoryName;
	}

	@Override
	public int boardModify(Map<String, Object>map) {
		session = sqlSessionFactory.openSession();
		int cnt = session.update("board.boardModify",map.get("boardVO"));
		session.commit();
		session.close();
		return cnt;
	}

	@Override
	public int deleteBoard(int board_seq) {
		session = sqlSessionFactory.openSession();
		int cnt = session.update("board.deleteBoard");
		session.commit();
		session.close();
		return cnt;
	}

	@Override
	public List<BoardVO> selectNoticeBoard(Map<String, Integer> map) {
		session = sqlSessionFactory.openSession();
		List<BoardVO> selectBoard = session.selectList("board.selectNoticeBoard",map);
		session.close();
		return selectBoard;
	}

	@Override
	public int insertBoard(BoardVO vo) {
		session = sqlSessionFactory.openSession();
		int cnt = session.insert("board.insertBoard",vo);
		session.commit();
		session.close();
		
		return cnt;
	}
	
	@Override
	public int insertReplyBoard(BoardVO vo) {
		session = sqlSessionFactory.openSession();
		int cnt = session.insert("board.insertReplyBoard",vo);
		session.commit();
		session.close();
		
		return cnt;
	}

	@Override
	public int boardCount() {
		session = sqlSessionFactory.openSession();
		int cnt = session.selectOne("board.count");
		session.close();
		return cnt;
	}
	
}
