package kr.or.ddit.file.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDaoInf;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class FileDaoImpl implements FileDaoInf{
	private static FileDaoInf dao = new FileDaoImpl();
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession session;
	
	private FileDaoImpl() {
		String resource = "db/mybatis/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static FileDaoInf getInstance() {
		return dao;
	}
	
	@Override
	public int insetFile(Map<String, Object> map) {
		session = sqlSessionFactory.openSession();
		int cnt = session.insert("files.insertFile",map.get("fileList"));
		session.commit();
		session.close();
		return cnt;
	}
	
}
