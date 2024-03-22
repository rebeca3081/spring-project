<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>replyMng.html(CRUD)</title>

<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

</head>
<body>
	<h3>댓글목록조회</h3>
		<div>
			<table border="1">
				<thead>
					<tr>
						<th>No.</th>
						<th>bno</th>
						<th>rno</th>
						<th>reply</th>
						<th>replyer</th>
						<th>replyDate</th>
						<th>updateDate</th>
						<th>수정/삭제</th>
					</tr>
				</thead>
				<tbody id="replyList">
									
				</tbody>
			</table>
		</div>
	
 
	<h3>댓글 등록</h3>
	<form method="post" name="frm">
		bno<input name="bno">
		reply<input name="reply">
		replyer<input name="replyer">
		replyDate<input name="replyDate">
		updateDate<input name="updateDate">

		<button type="button" id="saveBtn">등록</button>
	</form>
	
	
<script>
// 페이지 로드하자 마자 함수 호출
listReq();
// 리스트 요청
function listReq() {
	fetch('./reply/list')
	.then(res => res.json())
	.then(res => {
		//console.log(res);
		listRes(res);
	})		
}

// 리스트 응답
function listRes(res) {
	console.log(res)
	res.forEach((item, idx) => {
		let newTag = 
			`<tr>
				<td>\${idx+1}</td>
				<td>\${item.bno}</td>
				<td>\${item.rno}</td>
				<td>\${item.reply}</td>
				<td>\${item.replyer}</td>
				<td>\${item.replyDate}</td>
				<td>\${item.updateDate}</td>
				<td>
					<button>수정</button>
					<button>삭제</button>
				</td>
				<td>
					<button type="button" onclick="move(${item.rno})">조회</button>
				</td>
			</tr>`;
			
		replyList.innerHTML += newTag;
	})
}

// 댓글 등록 요청
function saveReq() {
	const bno = frm.bno.value;
	const reply = frm.reply.value;
	const replyer = frm.replyer.value;
	const replyDate = frm.replyDate.value;
	const updateDate = frm.updateDate.value;
	
	let param = {bno, reply, replyer, replyDate, updateDate}
	
	axios.post("./reply/insert", param)
		 .then(res => saveRes(res.data))	
}

// 댓글 등록 응답
function saveRes(res) {
	listReq();
}

saveBtn.addEventListener("click", e => {
	console.log("버튼클릭")
	saveReq();
})

</script>


</body>
</html>