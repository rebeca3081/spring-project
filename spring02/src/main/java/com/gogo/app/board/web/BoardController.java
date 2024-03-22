package com.gogo.app.board.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gogo.app.board.mapper.BoardMapper;
import com.gogo.app.board.service.BoardVO;
import com.gogo.app.board.service.SearchedVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	
	final BoardMapper mapper;
	
	// 전체목록
	@RequestMapping("/board/list")
	public String list(Model model, BoardVO bvo, SearchedVO ssvo) {
		List<BoardVO> boardList = mapper.getBoardList(bvo, ssvo);
		model.addAttribute("boardList", boardList);
		return "/board/list";
	}
	// 등록 화면
	@GetMapping("/board/insert")
	public void insert() {
		
	}
	
	// 등록 처리
	@PostMapping("/boardInsert")
	public String boardInsert(BoardVO vo) {
		System.out.println(vo + "==========");
		mapper.boardInsert(vo);
		return "redirect:/board/list";
	}
	
	// 단건조회
	
	// 삭제
	
	// 수정
}
