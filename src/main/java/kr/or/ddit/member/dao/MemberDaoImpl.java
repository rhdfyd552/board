package kr.or.ddit.member.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.member.model.MemberVO;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDaoImpl implements MemberDaoInf{
	private static MemberDaoInf dao = new MemberDaoImpl();
	private SqlSessionFactory sqlSessionFactory;
	
	private MemberDaoImpl(){
		String resource = "db/mybatis/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDaoInf getInstance(){
		return dao;
	}
	


	@Override
	public List<MemberVO> allMember() {
		SqlSession session = sqlSessionFactory.openSession();
		List<MemberVO> vo = session.selectList("member.allMember");
		session.close();
		return vo;
	}
	
}
