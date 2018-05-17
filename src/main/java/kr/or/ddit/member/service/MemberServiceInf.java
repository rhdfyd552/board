package kr.or.ddit.member.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.member.model.MemberVO;

public interface MemberServiceInf {
	public boolean loginMeber(MemberVO vo);
	
	public List<MemberVO> allMember();
	
	
}
