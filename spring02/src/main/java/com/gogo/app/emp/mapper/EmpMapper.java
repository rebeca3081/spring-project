package com.gogo.app.emp.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gogo.app.emp.service.EmpVO;
import com.gogo.app.emp.service.SearchVO;

@Mapper
public interface EmpMapper {
	List<EmpVO> getEmpList(@Param("vo") EmpVO vo, SearchVO svo); // 전체조회 + 조건 + 페이징 + 정렬
	EmpVO getEmpInfo(int employeeId); // 단건조회
	int insertEmp(EmpVO empVO); // 등록 return in or void
	int deleteEmp(int employeeId); // 삭제
	int updateEmp(EmpVO empVO); // 수정
	List<Map<String, Object>> getStat(); // 부서별 인원수 조회
}
