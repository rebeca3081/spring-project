package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.ReplyVO;
import com.example.demo.emp.SearchVO;

@Mapper
public interface ReplyMapper {
	List<ReplyVO> getReplyList(ReplyVO vo, SearchVO ssvo); // 전체 조회
	ReplyVO getReplyInfo(int rno); // 단건조회
	int replyInsert(ReplyVO vo); // 등록
	int replyUpdate(ReplyVO vo); // 수정
	int replydelete(int rno);
	
}
