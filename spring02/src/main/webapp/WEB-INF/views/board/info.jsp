<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.html</title>
</head>
<body>
	<h2>게시글</h2>
	
	<a href="/emp/list">목록으로</a>
	<table border="1">
		<tr>
			<th>employee_id</th>
			<td>${empInfo.employeeId}</td>
			<th>job_id</th>
			<td th:text=""
		<tr>
			<th>department_id</th>
			<td>${empInfo.departmentId}</td>
			<th>manager_id</th>
			<td>${empInfo.managerId}</td>
		</tr>
		<tr>
			<th>full_name</th>
			<td>${empInfo.firstName} ${empInfo.lastName}</td>
			<th>photo</th>
			<td>
				<img src="#" alt="">
				<!-- <img th:src="@{file:///D:/upload/{imgName}(imgName = ${emp.photo})}" style="width:100px;"> -->
			</td>
		</tr>
		<tr>
			<th>email</th>
			<th>phone</th>
			<th>salary</th>
			<th>hire_date</th>
		</tr>
		<tr>
			<td>${empInfo.email}</td>
			<td>${empInfo.phone}</td>
			<td>${empInfo.salary}</td>
			<td>${empInfo.hireDate}</td>
			
		</tr>
		<tr>
			<td colspan="4" style="text-align:center;">
				<button><a href="/emp/delete/${empInfo.employeeId}">삭제</a></button>
				<button><a href="/emp/update/${empInfo.employeeId}">수정</a></button>
			</td>
		</tr>
	</table>
	
</body>
</html>