package com.example.demo.ex.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Sample1Mapper {
	@Insert("INSERT INTO tbl_sample1 (col1) VALUES (#{data})")
	public int insertCol1(String data);
}
