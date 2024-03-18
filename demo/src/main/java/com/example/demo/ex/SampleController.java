package com.example.demo.ex;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@GetMapping(value = "/getText", produces = "application/json;charset=UTF-8")
	public String getText() {
		return "{\"text\" : \"안녕하세요.\"}"; // {"text" : "안녕하세요."}
		// return "헬로우";	
	}
	
	@GetMapping("/check")
	public ResponseEntity<SampleVO> check(Double height, Double weight) {
		SampleVO svo = new SampleVO(0, "" + height, "" + weight); // double -> string으로
		
		ResponseEntity<SampleVO> result = null;
		
		if(height > 150) {
			result = ResponseEntity.status(HttpStatus.OK).body(svo); // new ResponseEntity<>(결과값, 상태값)			
		} else {
			result = new ResponseEntity<>(HttpStatus.BAD_GATEWAY);						
		}
		return result;
	}
	
}
