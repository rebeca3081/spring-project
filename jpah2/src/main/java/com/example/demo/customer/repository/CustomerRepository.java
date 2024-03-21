package com.example.demo.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.customer.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	// 비어있어서도 잘 작동함
	
	List<Customer> findByNameLike(String name); // 이름으로 검색 (LIKE 연산자 사용)
}
