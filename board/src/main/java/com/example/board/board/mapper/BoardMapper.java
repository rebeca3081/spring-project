package com.example.board.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.board.board.BoardVO;

@Mapper
public interface BoardMapper {
	// 게시글 검색 페이징 (제목, 내용, 작성자 검색 동적 쿼리로 구현)
	BoardVO getBoardInfo(int boardNo);// 단건조회
	// 등록
	// 삭제
	// 수정
}
