package com.example.board.board;

import lombok.Data;

@Data
public class BoardVO {
	String boardNo;
	String title;
	String content;
	String writer;
	String writeDate;
	String clickCnt;
	String image;
}
