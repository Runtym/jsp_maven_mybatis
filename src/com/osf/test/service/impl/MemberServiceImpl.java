package com.osf.test.service.impl;

import java.util.List;
import java.util.Map;

import com.osf.test.dao.MemberDAO;
import com.osf.test.dao.impl.MemberDAOImpl;
import com.osf.test.service.MemberService;
import com.osf.test.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private MemberDAO mdao = new MemberDAOImpl();
	
	@Override
	public List<MemberVO> selectMembers(MemberVO mvo) {
		return mdao.selectMembers(mvo);
	}

	@Override
	public MemberVO selectMemberByIdAndPwd(MemberVO mvo) {
		return mdao.selectMemberByIdAndPwd(mvo);
	}

	@Override
	public int insertMember(Map<String, String> mvo) {
		return mdao.insertMember(mvo);
	}
}
