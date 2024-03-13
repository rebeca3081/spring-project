package com.example.demo.emp;

import java.util.Date;

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
	String phone; //PHONE_NUMBER
	Date hireDate;
	String jobId;
	Integer salary;
	Float comm;
	String managerId;
	String departmentId;
}
