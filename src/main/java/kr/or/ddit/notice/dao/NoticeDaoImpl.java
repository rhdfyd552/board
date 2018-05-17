package kr.or.ddit.notice.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.notice.model.NoticeVO;

public class NoticeDaoImpl implements NoticeDaoInf{
	private static NoticeDaoInf dao = new NoticeDaoImpl();
	private SqlSessionFactory sqlSessionFactory;
	
	private NoticeDaoImpl(){
		String resource = "db/mybatis/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static NoticeDaoInf getInstance() {
		return dao;
	}

	@Override
	public List<NoticeVO> getNotice() {
		SqlSession session = sqlSessionFactory.openSession();
		List<NoticeVO> noticeList = session.selectList("notice.getNotice");
		session.close();
		return noticeList;
	}
	@Override
	public int insertNotice(NoticeVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt= session.insert("notice.insertNotice",vo);
		session.commit();
		session.close();
		return cnt;
	}
	@Override
	public int updaetNotice(NoticeVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt= session.update("notice.updaetNotice",vo);
		session.commit();
		session.close();
		return cnt;
	}

}
