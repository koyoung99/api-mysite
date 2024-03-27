package com.javaex.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestDao {

	@Autowired
	private SqlSession sqlSession;

	// 리스트
	public List<GuestbookVo> guestSelect() {

		List<GuestbookVo> gList = sqlSession.selectList("guestbook.select");

		System.out.println(gList);

		return gList;
	}

	
	
	// 추가
	public int guestInsert(GuestbookVo guestVo) {

		int count = sqlSession.insert("guestbook.insert", guestVo);

		return count;
	}
	// 삭제

	public int guestDelete(GuestbookVo guestVo) {

		int count = sqlSession.delete("guestbook.delete", guestVo);
		System.out.println(guestVo);

		return count;
	}
	
	//ajax등록
		public int insertSelectKey(GuestbookVo guestVo) {
			System.out.println("GuestDao.insertSelectKey()");
			
			int count = sqlSession.insert("guestbook.insertSelectKey", guestVo);
			return count;
		}
		
		//데이터 1개 가져오기 no 1명데이터 가져오기
		public GuestbookVo guestSelectOne(int no) {
			System.out.println("GuestDao.guestSelectOne()");
			
			GuestbookVo guestVo =sqlSession.selectOne("guestbook.selectOne", no);
			return guestVo;
		}

}