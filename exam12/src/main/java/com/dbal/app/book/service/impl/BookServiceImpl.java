package com.dbal.app.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbal.app.book.mapper.BookMapper;
import com.dbal.app.book.model.BookVO;
import com.dbal.app.book.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired BookMapper bookDAO;

	@Override
	public List<BookVO> getBook(BookVO vo) {
		return bookDAO.getBook(vo);
	}

	@Override
	public int bookInsert(BookVO vo) {
		return bookDAO.bookInsert(vo);
	}

	@Override
	public List<BookVO> getRentList(BookVO vo) {
		return bookDAO.getRentList(vo);
	}

}
