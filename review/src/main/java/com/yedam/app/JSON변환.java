package com.yedam.app;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON변환 {
	public static void main(String[] args) throws MalformedURLException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		
		// object -> json
		EmpVO vo = new EmpVO("길동", "홍", 100);
		// new EmpVO("효은", "장"); // 기본생성자
		
		String str = objectMapper.writeValueAsString(vo);
		
		// json -> object
		String json = "{\"employeeId\":0,\"firstName\":\"길동\",\"lastName\":\"홍\",\"email\":null,\"phone\":null,\"hireDate\":null,\"jobId\":null,\"salary\":null,\"comm\":null,\"managerId\":null,\"departmentId\":null}";
		
		vo = objectMapper.readValue(json, EmpVO.class);
		
		// url -> object
		Map map = objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/todos/1"), Map.class);
		
		System.out.println(map.get("title"));
		
		// 배열 받기
		Map maps = objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/todos"), Map.class);
		
		
	}
}
