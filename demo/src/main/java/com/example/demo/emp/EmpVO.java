package com.example.demo.emp;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpVO { // 등록용 VO
	int employeeId;
	String firstName;
	String lastName;
	String email;
	@JsonIgnore
	String phone; //PHONE_NUMBER
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") // 입력 String -> Date로 변환
	@JsonFormat(pattern = "yyyy-MM-dd") // 출력 Date -> String
	Date hireDate;
	String jobId;
	Integer salary;
	Float comm;
	@JsonIgnore
	String managerId;
	@JsonProperty(value = "deptId")
	String departmentId;
}
