package com.example.demo.emp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.emp.service.EmpService;

import lombok.Setter;

@SpringBootTest
public class EmpServiceTest {
	@Setter(onMethod_ = @Autowired)
	EmpService empService; // 서비스 인터페이스만 넣어주면 구현 클래스를 찾아서 사용가능
	
	@Test
	public void 리스트페이지조회() {
		// 1. given : 테스트할때 필요한 값
		EmpVO evo = new EmpVO();
		SearchVO svo = new SearchVO();
		svo.setStart(0);
		svo.setEnd(10);;
		// 2. when : 테스트 할 내용
		Map<String, Object> map = empService.getEmpList(evo, svo);
		// 3. then : 결과 => assert를 이용! 주로 assertThat사용
		System.out.println(map.get("count"));
		assertThat(map.get("count")).isNotEqualTo(0); // 리스트가 있는지에 대한 여부
	}
}
