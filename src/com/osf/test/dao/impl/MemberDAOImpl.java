package com.osf.test.dao.impl;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.osf.test.dao.MemberDAO;
import com.osf.test.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {
	private static SqlSessionFactory ssFactory;
	static {
		InputStream is = MemberDAOImpl.class.getClassLoader()
				.getResourceAsStream("config/mybatis-config.xml");
		SqlSessionFactoryBuilder ssfBuilder 
				= new SqlSessionFactoryBuilder();
		ssFactory = ssfBuilder.build(is);
	}
	
	@Override
	public List<MemberVO> selectMembers(MemberVO mvo) {
		try(SqlSession ss = ssFactory.openSession()){
			return ss.selectList("com.osf.test.Member.selectList",mvo);
		}
	}

	@Override
	public MemberVO selectMemberByIdAndPwd(MemberVO mvo) {
		try(SqlSession ss = ssFactory.openSession()){
			return ss.selectOne("com.osf.test.Member.selectMemberByIdAndPwd",mvo);
		}
	}

	@Override
	public int insertMember(Map<String,String> mvo) {
		try(SqlSession ss = ssFactory.openSession()){
			if(ss.insert("com.osf.test.Member.insertMember",mvo)==1) {
				ss.commit();
				return 1;
			}
		}
		return 0;
	}
}
