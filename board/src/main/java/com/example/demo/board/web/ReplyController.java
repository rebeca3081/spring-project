package com.example.demo.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.board.ReplyVO;
import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.emp.SearchVO;

@RestController
public class ReplyController {
	
	@Autowired ReplyMapper mapper;
	
	// 댓글 전체조회 페이지 이동
	@RequestMapping("/replyMng")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("replyMng");
		return mv;
	}
	
	// 댓글 전체 조회 데이터
	@GetMapping("/reply/list")
	public List<ReplyVO> replyList(ReplyVO vo, SearchVO svo){
		svo.setStart(0);
		svo.setEnd(10);
		return mapper.getReplyList(vo, svo);
	}
	
	
	// 댓글 등록
	@PostMapping("/reply/insert")
	public ReplyVO insert(@RequestBody ReplyVO vo) {
		System.out.println(vo + "==============================");
		mapper.replyInsert(vo);
		return vo;
	}
	
	// 단건조회
	
	
}
