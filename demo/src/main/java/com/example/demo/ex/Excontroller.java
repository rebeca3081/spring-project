package com.example.demo.ex;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.emp.EmpVO;

@Controller
public class Excontroller {
	@RequestMapping("/ex2") // form actiion과 맞추기
	public String ex2(EX2VO vo) {
		System.out.println(vo);
		return "index";
	}
	
	@RequestMapping("/ex3")
	public String ex3(ListCodeVO lcvo) {
		System.out.println(lcvo);
		return "index";
	}
	
	@RequestMapping("/ex4/{userName}/{age}")
	public String ex4(@PathVariable String userName, @PathVariable(name = "age") int userAge) {
		System.out.println("userName : " + userName + ", userAge : " + userAge);
		return "index";
	}
	
	@RequestMapping("/ex5") // 커멘드 객체 없이 파라미터 localhost:8081/ex4userName=xxx&age=20
	public String ex5(String username, 
					@RequestParam(name = "userage", required = false, defaultValue = "10") Integer age) { // 값의 초기값이 필요하면 사용하기
		System.out.println("username : " + username + ", age : " + age);
		return "index";
	}
	
	@RequestMapping("/ex6")
	public String ex6(EmpVO vo, MultipartFile[] photos) throws IllegalStateException, IOException {
		System.out.println(vo);
		if(photos != null) {
			for(MultipartFile photo: photos) {
				if(!photo.isEmpty()) { // if(photo.getSize > 0){}
					// 파일 생성
					File file = new File("d:/upload", photo.getOriginalFilename());
					// 파일저장
					photo.transferTo(file);
					
					System.out.println("파일명 : " + photo.getOriginalFilename());
					System.out.println("파일크기 : " + photo.getSize());						
				}
			}			
		}
		return "index";
		
	}
	
}
