package com.springbook.biz.board.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

// Spring에서 Mybatis연동 방법 1 : extends SqlSessionDaoSupport
@Repository
public class BoardDAOMyBatis01 extends SqlSessionDaoSupport{

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	public void insertBoard(BoardVO vo) {
		getSqlSession().insert("BoardDAO.insertBoard", vo);
		getSqlSession().commit();
	}
	
	public void updatetBoard(BoardVO vo) {
		getSqlSession().update("BoardDAO.updatetBoard", vo);
		getSqlSession().commit();
	}
	
	public void deletetBoard(BoardVO vo) {
		getSqlSession().insert("BoardDAO.deletetBoard", vo);
		getSqlSession().commit();
	}
	
	public BoardVO getBoard(BoardVO vo) {
		return (BoardVO) getSqlSession().selectOne("BoardDAO.getBoard",vo);
	}
	
	public List <BoardVO> getBoardList(BoardVO vo) {
		getSqlSession().selectList("BoardDAO.getBoardList",vo);
	}
	
	
}
