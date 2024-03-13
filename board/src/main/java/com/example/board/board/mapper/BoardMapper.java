package com.example.board.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.board.board.BoardVO;
import com.example.board.board.SearchVO;

@Mapper
public interface BoardMapper {
	List<BoardVO> getBoardList(@Param("bvo") BoardVO bvo, SearchVO svo);// 게시글 검색 페이징 (제목, 내용, 작성자 검색 동적 쿼리로 구현)
	BoardVO getBoardInfo(int boardNo); // 단건조회
	int boardInsert(BoardVO vo); // 등록
	int boardUpdate(BoardVO vo); // 수정
	int deleteBoard(int bno); // 삭제
}
