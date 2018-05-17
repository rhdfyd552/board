package kr.or.ddit.member.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.dao.MemberDaoInf;
import kr.or.ddit.member.model.MemberVO;

public class MemberServiceImpl implements MemberServiceInf{
	private static MemberServiceInf service = new MemberServiceImpl();
	private MemberDaoInf dao;
	
	private MemberServiceImpl(){
		dao = MemberDaoImpl.getInstance();
	}
	
	public static MemberServiceInf getInstancce() {
		return service;
	}
	
	@Override
	public boolean loginMeber(MemberVO vo) {
		String mem_id = vo.getMem_id();
		String mem_pass = vo.getMem_pass();
		
		List<MemberVO> memList = dao.allMember();
		
		for(MemberVO memVo : memList){
			if(memVo.getMem_id().equals(mem_id) && memVo.getMem_pass().equals(mem_pass)){
				return true;
			}
		}
		
		return false;
	}

	@Override
	public List<MemberVO> allMember() {
		return dao.allMember();
	}

}
