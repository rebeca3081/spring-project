package com.dbal.app.book.mapper;

import java.util.List;

import com.dbal.app.book.model.BookVO;

public interface BookMapper {

	public List<BookVO> getBook(BookVO vo); // 전체조회
	public int bookInsert(BookVO vo); // 등록
	public List<BookVO> getRentList(BookVO vo); // 대여 현황조회
}

