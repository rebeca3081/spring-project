package com.example.board.board;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.BoardVO;
import com.example.demo.board.SearchedVO;
import com.example.demo.board.mapper.BoardMapper;

@SpringBootTest
public class BoardMapperTest {
	@Autowired BoardMapper mapper;
	
	@Test
	public void 게시글전체조회검색() {
		BoardVO bvo = BoardVO.builder()
							.title("오늘")
							.content("테이블")
							.writer("은")
							.build();
		
		SearchedVO svo = new SearchedVO();
							
		List<BoardVO> list = mapper.getBoardList(bvo, svo);
		
		// 게시글 검색결과 조회
		for(BoardVO board : list) {
			System.out.println("No: " + board.getBoardNo() + "제목: " + board.getTitle() + "내용: " + board.getContent()
							+ "작성자: " + board.getTitle()+ "작성일: " + board.getWriteDate());
		}
		
		
	}
	
	@Test
	public void 게시글단건조회() {
		int boardNo = 10;
		BoardVO bvo = mapper.getBoardInfo(boardNo);
		System.out.println(bvo);
		//assertEquals(Integer.toString(boardNo), bvo.getBoardNo());
		assertEquals(boardNo, bvo.getBoardNo());
		
	}
	
	@Test
	public void 게시글등록() {
		BoardVO bvo = BoardVO.builder()
							.title("게시글입력중22")
							.content("mybatis를 이용한 게시글 등록22")
							.writer("장세은")
							.build();
		int result = mapper.boardInsert(bvo);
		
		// 등록된 게시글 번호
		System.out.println("등록된 게시글 번호 : " + bvo.getBoardNo());
		// 등록건수
		System.out.println(result + "이 등록 완료 되었습니다.");
		
	}
	
	@Test
	public void 게시글수정() {
		BoardVO bvo = BoardVO.builder()
							.boardNo(23)
							.content("수정테스트중입니다.")
							.build();
		int result = mapper.boardUpdate(bvo);
		System.out.println(bvo.toString());
		
		System.out.println(result + "이 수정되었습니다.");
	}
	
	@Test
	public void 게시글삭제() {
		int delResult = mapper.deleteBoard(24);
		System.out.println(delResult + "이 삭제되었습니다.");
	}
	
} // end of test class
