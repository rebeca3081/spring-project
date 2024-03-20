package com.example.demo.customer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor // 기본생성자
@Builder // 생성자 대신
@AllArgsConstructor
@Entity // 테이블과 링크될 클래스를 알림
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(length = 20, nullable = false)
	private String name;
	private String phone;
}
