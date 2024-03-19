/**
 * empMng.js
 */

// 즉시 실행함수 var empService = {listReq, infoReq, saveReq}
var empService = (function(){

	// 리스트 요청
	async function listReq(p) {
		const param = `?page=${p}`;
		// 비동기
		/*
		axios.get('/ajax/empList' + param)
			.then(res => listRes(res.data));
		*/
			
		// 동기
		const res = await axios.get('/ajax/empList' + param);
		listRes(res.data);
		
		/*
		fetch('/ajax/empList' + param)
		.then(res => res.json())
		.then(res => {
			//console.log(res);
			listRes(res);
		})
		*/
	}
	
	// 날짜 포멧 함수
	//function dateFormat(dt) {
	//	Date date = new Date();
	//}
	
	// 리스트 응답
	function listRes(res) {
		//console.log(res)
		// 목록 출력
		res.data.forEach((item, idx) => {
			// console.log(item)
			empList.innerHTML += makeTr(item, idx);
		})
		// 페이징
		navs.innerHTML = makePage(res.paging);
	}
	
	function makeTr(obj, idx) {
		let bonusBtn = '<button>신청</button>';
		if(obj.salary > 10000) {
			bonusBtn = '<button>미신청</button>'
		}
		let newTag = 
			`<tr>
				<td>${idx+1}</td>
				<td onclick="infoReq(${obj.employeeId})">${obj.employeeId}</td>
				<td>${obj.firstName} ${obj.lastName}</td>
				<td>${obj.hireDate}</td>
				<td>${obj.salary}</td>
				<td>${obj.email}</td>
				<td>
					${bonusBtn}
				</td>
				<td>
					<button type="button" onclick="move(${obj.employeeId})">조회</button>
				</td>
			</tr>`;
		return newTag;
	}
	
	function makePage(paging) {
		console.log(paging)
		let tag = `<nav aria-label="...">
		  <ul class="pagination">`;
		
		// 이전 버튼
		if(paging.startPage > 1) {
			tag += `<li class="page-item">
		        <a class="page-link" href="javascript:gopage(${paging.startPage-1})">Previous</a></li>`;
		}
		// 페이지 번호
		for(i=paging.startPage; i <= paging.endPage; i++) {
			tag += `<li class="page-item">
				<a class="page-link" href="javascript:gopage(${i})">${i}</a></li>`;
		}
		// 다음 버튼
		if(paging.endPage <= paging.lastPage) {
			tag += `<li class="page-item">
				<a class="page-link" href="javascript:gopage(${paging.endPage + 1})">Next</a></li>`;
		    tag += `</ul>
		    	</nav>`;
		}
		return tag;
	}
	
		
		
	
	// 등록 요청
	function saveReq() {
		// 1.queryString : ?key=value
		const lastName = frm.lastName.value;
		const email = frm.email.value;
		const hireDate = frm.hireDate.value;
		const jobId = frm.jobId.value;
		// let param = `lastName=${lastName}&email=${email}&hireDate=${hireDate}&jobId=${jobId}`;
		// let param = new FormData(document.frm); // 2. FormData
		
		let param = {lastName, email, jobId, hireDate }
		/*
		fetch("/ajax/emp",{
			method : "post",
			headers: {
			      "Content-Type": "application/json"
			},
			body : JSON.stringify(param)
		})
		*/
		axios.post("/ajax/emp", param)
			.then(res => saveRes(res.data))
	}
	// 등록 응답
	function saveRes(res) {
		listReq(1);
	}
	
	
	// 상세조회 요청
	function infoReq(employeeId) {
		fetch(`/ajax/emp/${employeeId}`)
		.then(res => res.json())
		.then(res => infoRes(res))
		
	}
		
	// 상세조회 응답
	function infoRes(res) {
		console.log(res)
		// input tag에 표시
		frm.email.value = res.email;
		frm.lastName.value = res.lastName;
		frm.jobId.value = res.jobId;
		frm.hireDate.value = res.hireDate;
	}
	
	return {listReq, infoReq, saveReq}
	
})();