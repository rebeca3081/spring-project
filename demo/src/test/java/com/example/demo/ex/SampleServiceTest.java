package com.example.demo.ex;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.ex.service.SampleService;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class SampleServiceTest {
	
	@Setter(onMethod_ = @Autowired)
	SampleService sampleService;

	@Test
	public void 트랜잭션() {
		String str = "테스트입니다.";
		
		log.info("단어길이능? " + str.getBytes().length);
		
		sampleService.addData(str);
	}
}
