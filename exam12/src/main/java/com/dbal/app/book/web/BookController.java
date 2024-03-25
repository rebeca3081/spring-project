package com.dbal.app.book.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dbal.app.book.model.BookVO;
import com.dbal.app.book.service.BookService;

@Controller
public class BookController {
	
	@Autowired BookService bookService;
	
	// 시작화면
	@RequestMapping("/")
	public String index() {
		return "index";
	}

    // 등록 화면
	@GetMapping("/book/insert")
	public String goInsert() {
		return "book/insert";
	}
	
	// 등록 처리
	@PostMapping("/bookInsert")
	public String insert(BookVO vo) {
		System.out.println("=============" + vo);
		bookService.bookInsert(vo);
		return "redirect:/book/list";
	}
	
	// 전체 조회
	@RequestMapping("/book/list")
	public String book(Model model, BookVO vo) {
		List<BookVO> bvo = bookService.getBook(vo);
		model.addAttribute("bookList", bvo);
		return "book/list";
	}
	
	// 도서 대여 현황 조회
	@RequestMapping("/book/rentlist")
	public String rent(Model model, BookVO vo) {
		List<BookVO> bvo = bookService.getRentList(vo);
		model.addAttribute("rentList", bvo);
		return "book/rentlist";
	}
    
}
