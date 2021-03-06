package com.springbook.biz.board.impl;

import java.sql.SQLException;
import java.util.List;

import com.springbook.biz.board.BoardVO;

public class BoardServiceClient_MyBatis {
	public static void main(String[] args) throws SQLException{
		
	
		BoardDAOMyBatis boardDAO = new BoardDAOMyBatis();
		
		BoardVO vo = new BoardVO();
		
		vo.setTitle("myBatis 제목");
		vo.setWriter("홍길동");
		vo.setContent("myBatis 내용입니다.");
		
		boardDAO.insertBoard(vo);
		
		//Null값이 넘어가지 않도록
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		
		List<BoardVO>boardList = boardDAO.getBoardList(vo); 
		
		for (BoardVO boardVO : boardList) {
			System.out.println("-->" + boardVO);
		}
	
	}
			
}
