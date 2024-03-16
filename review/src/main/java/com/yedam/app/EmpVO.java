package com.yedam.app;

import java.util.Date;
import java.util.Objects;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public class EmpVO { // 등록용 VO
	// 필드
	int employeeId;
	final String firstName;
	final String lastName;
	private String email;
	private String phone; //PHONE_NUMBER
	private Date hireDate;
	private String jobId;
	final Integer salary;
	private Float comm;
	private String managerId;
	private String departmentId;
	
	// 기본생성자
	// public EmpVO() {}
	
	// 생성자 -> 객체가 생성될 때 필드 초기화

	
	// setter, getter
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public int getSalary() {
		return this.salary;
	}
	@Override
	public boolean equals(Object obj) {
		EmpVO vo = (EmpVO) obj; // 부모 자식간의 형변환 가능
		return this.firstName.equals(vo.getFirstName())
			&& this.lastName.equals(vo.getLastName());
	}
	@Override
	public int hashCode() {
		return Objects.hash(this.firstName, this.lastName);
	}
	
	
	
}
