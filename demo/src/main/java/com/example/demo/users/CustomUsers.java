package com.example.demo.users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;

@Getter
public class CustomUsers implements UserDetails {

	private UsersVO usersVO;
	
	// 초기화 해주는 생성자
	public CustomUsers(UsersVO usersVO) {
		this.usersVO = usersVO;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { // 중요
		// String grade를 -> collection<GrantedAuthority> 타입으로 변경
		List<SimpleGrantedAuthority> authlist = new ArrayList<>();
		
		authlist.add(new SimpleGrantedAuthority(usersVO.getGrade()));
		
		return authlist;
	}

	@Override
	public String getPassword() {
		return usersVO.getUserpw();
	}

	@Override
	public String getUsername() {
		return usersVO.getUserid();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() { // 계정 잠김
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() { // 로그이 가능여부, 휴면회원 등등
		return true;
	}
}
