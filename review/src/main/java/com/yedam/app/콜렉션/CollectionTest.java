package com.yedam.app.콜렉션;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import com.yedam.app.EmpVO;

/*
 * 자료구조
 * List, Set, Map
 * List - 					, index		--> 순차적 목록
 * Set - 					, index		--> 중복값 허용 X
 * Map - <k,v> 키와 값의 쌍		, key		--> 검색속도가 빠름
 */

public class CollectionTest {

	public static void main(String[] args) {
		// 중복값 제거
		List<Integer> list = Arrays.asList(3, 3, 10, 11, 14, 3);
		//System.out.println(list);
		
		// list -> set
		HashSet set = new HashSet<>(list);
		//System.out.println(set);
		
		
		//List<EmpVO>
		List<EmpVO> empList = new ArrayList<>();
		
		empList.add(new EmpVO("park", "aaa", 20000));
		empList.add(new EmpVO("jang", "bbb", 14000));
		empList.add(new EmpVO("kim", "ccc", 30000));
		empList.add(new EmpVO("park", "bbb", 20000));
		
		// 중복값 재고
		HashSet<EmpVO> empSet = new HashSet<>(empList);
		//System.out.println(empSet.size());
		
		// 필터링 : 급여가 15000이상인 사원만 검색
		
		// 새로운 list 객체 생성
		List<EmpVO> newEmpList = new ArrayList<>();		
		for(EmpVO vo : empSet) {
			if(vo.getSalary() > 15000) {
				newEmpList.add(vo);
			}
		}
		System.out.println(newEmpList.size());
		
		
		// stream => filter, collection
		// lastName = bbb 인 사람
		newEmpList = empSet.stream() // 읽고
							.filter(vo -> vo.getLastName().contains("b")) // 필터링해서 
															// 문자열 비교 : equals, contains, startWith, endWith
							.collect(Collectors.toList()); // 모아줌
		System.out.println(newEmpList.toString());
		
		
		
		
		
		
		
		
		
		
	}

}
