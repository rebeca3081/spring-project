package com.example.demo.emp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.emp.mapper.EmpMapper;

@SpringBootTest // 단위테스트
public class EmpMapperTest {
	
	@Autowired EmpMapper mapper; // Mapper test
	
	@Test
	public void 사원통계() {
		List<Map<String, Object>> list = mapper.getStat();
		// for문 이용 부서번호, 인원수
		for(Map<String, Object> map : list) {
			System.out.println(map.get("name") + ":" + map.get("CNT"));
		}
//		System.out.println(list);
	}
	
	@Test
	public void 사원삭제() {
		int delResult = mapper.deleteEmp(1000);
		System.out.println("삭제결과=" + delResult);
		
	}
	
	@Test
	public void 사원등록() {
		// vo 객체 생성
		// 롬복 빌더
		EmpVO vo = EmpVO.builder()
						//.employeeId(301)
						.lastName("hahahahah")
						.email("test.goole.com")
						.hireDate(new Date(2021,9,25))
						.jobId("AD_VP")
						.build();
		

//		EmpVO vo = new EmpVO();
//		vo.setEmployeeId(1000);
//		vo.setLastName("Hyoeun");
//		vo.setEmail("gydms@google.com");
//		vo.setHireDate(new Date(2024,2,13));
//		vo.setJobId("IT_PROG");
		
		// 값을 담고
		int result = mapper.insertEmp(vo);
		
		// 등록된 사번을
		System.out.println("등록된 사번 : " + vo.getEmployeeId());
		// 출력
		System.out.println("등록건수=" + result);
		
		
	}
	
	@Test
	public void 사원전체조회() {
		EmpVO vo = new EmpVO();
		SearchVO svo = new SearchVO();
		//vo.setDepartmentId("50");
		//vo.setFirstName("Kevin");
		//vo.setManagerId("103");
		//vo.setStart(1);
		//vo.setEnd(100);
		
		svo.setEmployeeIds(new int[] {100, 101, 102});
		
		List<EmpVO> list = mapper.getEmpList(vo, svo);
		
		// for employeeId, firstName 출력
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println("employeeId : " + list.get(i).getEmployeeId());
//			System.out.println("firstName : " + list.get(i).getFirstName());
//		}
		
		// 향상된 for문
		for(EmpVO emp : list) {
			System.out.println(emp.getEmployeeId() + ":" + emp.getFirstName());
		}
		
		System.out.println("결과는=" + list.size());
		// assertEquals(list);
	}
	
	@Test
	public void 사원단건조회() {
		int employeeId = 100;
		EmpVO vo = mapper.getEmpInfo(employeeId);
		System.out.println(vo);
		assertEquals(employeeId, vo.getEmployeeId());
	}
}
