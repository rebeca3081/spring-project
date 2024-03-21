package com.example.demo.customer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.customer.domain.Customer;
import com.example.demo.customer.repository.CustomerRepository;

@SpringBootTest
public class CustomerRepositoryTest {
	
	@Autowired
	CustomerRepository repo;
	
	@AfterEach // 단위 테스트가 끝날 때 마가 수행되는 메소드를 지정
	public void cleanup() {
		repo.deleteAll();
	}
	
	@Test
	public void 저장_조회() {
		// given
		String name = "고길동";
		String phone = "010-1010-1010";
		
		Customer customer = Customer.builder()
									.name(name)
									.phone(phone)
									.build();
			
		repo.save(customer); // 등록
		
		// when
		List<Customer> list = repo.findByNameLike(name);
		
		// then
		Customer result = list.get(0);
		
		assertThat(result.getName()).isEqualTo(name);
	}
}
