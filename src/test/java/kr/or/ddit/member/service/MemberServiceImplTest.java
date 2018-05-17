package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.member.model.MemberVO;

import org.junit.Test;

public class MemberServiceImplTest {
	private MemberServiceInf service = MemberServiceImpl.getInstancce();
	@Test
	public void loginMeber() {
		/***Given***/
		

		MemberVO vo = new MemberVO();
		vo.setMem_id("sally");
		vo.setMem_pass("12342");
		
		boolean result=service.loginMeber(vo);
		/***Then***/
		assertEquals(false, result);

	}
	
	@Test
	public void allMemberTest(){
		/***Given***/
		

		/***When***/
		List<MemberVO>memList = service.allMember();
		/***Then***/
		assertEquals(5, memList.size());
		assertEquals("sally", memList.get(0).getMem_id());
		assertEquals("1234", memList.get(0).getMem_pass());


	}
}
