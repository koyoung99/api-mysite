package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession; // mybatis에 xml이 있어야 import됨

	// 로그인
	public UserVo userSelectByIdPw(UserVo userVo) {
		System.out.println("UserDao.userSelectByIdPw()");

		UserVo authUser = sqlSession.selectOne("user.selectByIdPw", userVo);
//		System.out.println(authUser);

		return authUser;
	}
	
	// 회원가입
	public int userInsert(UserVo userVo) {
		System.out.println("UserDao.exeJoin()");
		
		int count=sqlSession.insert("user.insert",userVo);
		
		return count;
	}
	

	// 회원정보수정 폼(조회 no)
	public UserVo userSelectOneByNo(int no) {
		System.out.println("UserDao.userSelectOneByNo()");

		UserVo userVo = sqlSession.selectOne("user.selectOneByNo", no);
		return userVo;
	}

	// 회원수정
	public int userUpdate(UserVo userVo) {
		System.out.println("UserDao.userUpdate()");
		System.out.println(userVo);
		int count = sqlSession.update("user.update", userVo);

		
		return count;
	}

}
