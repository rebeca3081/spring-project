package com.yedam.app.콜렉션;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yedam.app.EmpVO;

public class 맵테스트 {

	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("100", "park");
		map.put("101", "kim");
		map.put("102", "choi");
		
		String name = (String) map.get("101");
		
		// 반복문
		for(String key : map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}
		
		// VO == Map
		List<HashMap<String, Object>> empList = new ArrayList<HashMap<String, Object>>();
		map = new HashMap<>();
		map.put("firstName", "park");
		map.put("lastName", "aaa");
		map.put("salary", 20000);
		empList.add(map);
		
		map = new HashMap<>();
		map.put("firstName", "kim");
		map.put("lastName", "bbb");
		map.put("salary", 10000);
		empList.add(map);
		
//		for(HashMap<String, Object> ele : empList) {
//			System.out.println(ele.get("firstName"));
////			System.out.println(ele.get("salary"));
////			for(String key : ele.keySet()) {
////				System.out.println(key + " : " + ele.get(key));
////			}
//		}
		
		// filter 급여가 15000이상만
		System.out.println("=========");
		for(HashMap<String, Object> ele : empList) {
			if( (Integer) ele.get("salary") >= 15000) {
				System.out.println(ele.get("firstName"));
			}
		}
		
		
		
		// stream 사용해보기
//		empList.stream()
//				.filter(map -> { return (Integer) map.get("salary") > 15000)}
//				.peek(System.out::println);

	}

}
