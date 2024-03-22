package com.gogo.app.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gogo.app.board.service.ReplyVO;
import com.gogo.app.board.service.SearchedVO;

@Mapper
public interface ReplyMapper {
	List<ReplyVO> getReplyList(@Param("rvo") ReplyVO vo, @Param("ssvo") SearchedVO ssvo); // 전체 조회
	ReplyVO getReplyInfo(int rno); // 단건조회
	int replyInsert(ReplyVO vo); // 등록
	int replyUpdate(ReplyVO vo); // 수정
	int replydelete(int rno);
	
}
