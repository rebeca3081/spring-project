package com.example.demo.di;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Setter;

@SpringBootTest
public class DITest {
	@Autowired // 컨테이너에서 등록된 Bean 꺼내쓰기
	private Restaurant restaurant; // 1.필드 주입방식
	
	
	@Setter(onMethod_ = {@Autowired})
	private Restaurant restaurant1; // 2.Setter 주입방식
	
	@Test
	public void 스코프비교() {
		assertThat(restaurant==restaurant1).isTrue();
	}
	
	//@Test
	public void test() {
		assertThat(restaurant.getChef()).isNotNull(); // System.out.println(); 으로 테스트 X
		
	}
	
}
