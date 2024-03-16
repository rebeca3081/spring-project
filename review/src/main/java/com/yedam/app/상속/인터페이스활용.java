package com.yedam.app.상속;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.yedam.app.EmpVO;

public interface 인터페이스활용 {
	public static void main(String[] args) {
		
		List<EmpVO> list = new ArrayList<>();
		
		list.add(new EmpVO("park", "aaa", 20000));
		list.add(new EmpVO("jang", "bbb", 15000));
		list.add(new EmpVO("kim", "ccc", 30000));
		list.add(new EmpVO("aria", "ddd", 11000));
		
		// sort
		// 람다식, 익명함수 -> 익명클래스 생성 후 객체생성
		// 화살표 함수 '->' 는 인터페이스를 구현하는 클래스의 메소드가 1개일 때 가능  
		Collections.sort(list, (EmpVO o1, EmpVO o2) -> o1.getFirstName().compareTo(o2.getFirstName()) );
		// Collections.sort(list, (EmpVO o1, EmpVO o2) -> o2.getFirstName().compareTo(o1.getFirstName()) ); // 역순
		for(EmpVO vo : list) {
			System.out.println(vo.getFirstName() + "-" + vo.getLastName());
			
		}
		
		System.out.println("==============");
		// 양수 -> 0, 음수 -> 
		Collections.sort(list, (EmpVO o1, EmpVO o2) -> o1.getSalary() - o2.getSalary());
		// Collections.sort(list, (EmpVO o1, EmpVO o2) -> o2.getSalary() - o1.getSalary());
		for(EmpVO vo : list) {
			System.out.println(vo.getFirstName() + "-" + vo.getSalary());
		}
	}
}

	
