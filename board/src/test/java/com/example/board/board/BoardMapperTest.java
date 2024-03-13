package com.example.board.board;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.board.board.mapper.BoardMapper;

@SpringBootTest
public class BoardMapperTest {
	@Autowired BoardMapper mapper;
	
	@Test
	public void 게시글단건조회() {
		int boardNo = 10;
		BoardVO bvo = mapper.getBoardInfo(boardNo);
		System.out.println(bvo);
		assertEquals(Integer.toString(boardNo), bvo.getBoardNo());
		
	}
}
