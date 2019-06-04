package com.osf.test.service;

import java.util.List;
import java.util.Map;

import com.osf.test.vo.MemberVO;

public interface MemberService {
	List<MemberVO> selectMembers(MemberVO mvo);
	MemberVO selectMemberByIdAndPwd(MemberVO mvo);
	int insertMember(Map<String,String> mvo);
}
