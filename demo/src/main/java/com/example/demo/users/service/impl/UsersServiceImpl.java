package com.example.demo.users.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.users.CustomUsers;
import com.example.demo.users.UsersVO;
import com.example.demo.users.mapper.UsersMapper;
import com.example.demo.users.service.UsersService;

import lombok.Setter;
@Service
public class UsersServiceImpl implements UsersService, UserDetailsService { // 인터페이스 다중 상속
	
	@Setter(onMethod_ = @Autowired)
	private UsersMapper usersMapper;

	@Override
	public UsersVO getUsersInfo(String userid) {
		return usersMapper.getUsersInfo(userid);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsersVO userVO = usersMapper.getUsersInfo(username);
		if(userVO == null) {
			throw new UsernameNotFoundException("id not found");
		}
		return new CustomUsers(userVO);
	}

}
