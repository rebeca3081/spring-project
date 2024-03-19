package com.example.demo.emp.service;

import java.util.List;
import java.util.Map;

import com.example.demo.emp.EmpVO;
import com.example.demo.emp.SearchVO;

public interface EmpService { // 사용자 요구사항에 따른 서비스만
	Map<String, Object> getEmpList(EmpVO vo, SearchVO svo); // 전체조회(조건 + 페이징 + 정렬) + 전체건수
	EmpVO getEmpInfo(int employeeId); // 단건조회
	int insertEmp(EmpVO empVO); // 등록
	int deleteEmp(int employeeId); // 삭제
	List<Map<String, Object>> getStat(); // 부서별 인원수 조회
}
