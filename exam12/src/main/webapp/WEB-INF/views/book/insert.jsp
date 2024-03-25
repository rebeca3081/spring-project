<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html><html><head><title>  </title></head>
<body>
	<header>
		<h1>도서대여관리</h1>
	</header>
	<nav>
		<ul>
			<li><a href="../book/insert">도서 등록</a></li>
			<li><a href="../book/list">도서 목록 조회/수정</a></li>
			<li><a href="../book/rentlist">대여 현황 조회</a></li>
			<li><a href="/">홈으로</a></li>
		</ul>
	</nav>
	<section>
		<h3>도서 등록</h3>
		<form method="post" name="frm" action="../bookInsert"
			enctype="application/x-www-form-urlencoded">
			<table border="1">
				<tr>
					<th>도서번호</th>
					<td><input name="bookNo" type="text" disabled></td>
				</tr>
				<tr>
					<th>도서명</th>
					<td><input name="bookName" type="text"></td>
				</tr>
				<tr>
					<th>도서표지</th>
					<td><input name="bookCoverimg" type="text"></td>
				</tr>
				<tr>
					<th>출판일자</th>
					<td><input name="bookDate" type="date"></td>
				</tr>
				<tr>
					<th>금액</th>
					<td><input name="bookPrice" type="number"></td>
				</tr>
				<tr>
					<th>출판사</th>
					<td><input name="bookPublisher" type="text"></td>
				</tr>
				<tr>
					<th>도서소개</th>
					<td colspan="3">
						<textarea rows="20" cols="100" name="bookInfo"></textarea>
					</td>
				</tr>
			</table>
			<button id="addBtn">등록</button>
			<button>조회</button>
		</form>
	</section>
	<footer>
			<span>HRDKOREA~~</span>
	</footer>
	
	<script>
		addBtn.addEventListener("click", e => {
			if(frm.bookName.value == '') {
				e.preventDefault();
				alert("도서명이 입력되지 않았습니다.");
				frm.bookName.focus();
			}
			else {
				alert("도서 등록이 완료 되었습니다.");
			}
		})
		
	</script>
</body>
</html>