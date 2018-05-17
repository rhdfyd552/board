package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.member.model.MemberVO;

import org.junit.Test;

public class MemberDaoImplTest {
	private MemberDaoInf dao = MemberDaoImpl.getInstance();
	
	
	@Test
	public void allMemberTest(){
		/***Given***/
		

		/***When***/
		List<MemberVO>memList = dao.allMember();
		/***Then***/
		assertEquals(5, memList.size());
		assertEquals("sally", memList.get(0).getMem_id());
		assertEquals("1234", memList.get(0).getMem_pass());

	}

}
