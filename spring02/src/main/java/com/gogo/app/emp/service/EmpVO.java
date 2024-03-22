package com.gogo.app.emp.service;


import java.sql.Date;

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
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date hireDate;
	String jobId;
	Integer salary;
	Float comm;
	String managerId;
	String departmentId;
	String photo;
}
