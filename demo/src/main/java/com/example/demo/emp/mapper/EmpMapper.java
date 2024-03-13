package com.example.demo.emp.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import com.example.demo.emp.EmpVO;
import com.example.demo.emp.SearchVO;

@Mapper
public interface EmpMapper {
	List<EmpVO> getEmpList(@Param("vo") EmpVO vo, SearchVO svo); // 전체조회 + 조건 + 페이징 + 정렬
	EmpVO getEmpInfo(int employeeId); // 단건조회
	int insertEmp(EmpVO empVO); // 등록 return in or void
	int deleteEmp(int employeeId); // 삭제
	List<Map<String, Object>> getStat(); // 부서별 인원수 조회
}
