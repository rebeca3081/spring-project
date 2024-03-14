package com.example.demo.di;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor // final 초기화
@Component // 컨테이너에 Bean 등록
//@Scope("prototype") // singletone, prototype, request, session 
public class Restaurant {
	
	//@Autowired // 1.필드 주입방식
	//@Setter(onMethod_ = {@Autowired}) // 2.Setter 주입방식(lombok시)
	// private Chef chef;
	final private Chef chef; // 3.생성자 주입방식 (lombok시)

	
	
	
}
