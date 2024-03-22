package com.gogo.app.emp.service;

import lombok.Data;

@Data
public class SearchVO {
	int start = 1;
	int end = 10;

	int[] employeeIds;
}
