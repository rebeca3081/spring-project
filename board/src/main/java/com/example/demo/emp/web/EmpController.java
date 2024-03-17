package com.example.demo.emp.web;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.emp.EmpVO;
import com.example.demo.emp.SearchVO;
import com.example.demo.emp.mapper.EmpMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller // 컨테이너 빈(Bean) 등록 + 사용자요청처리를 커멘트 핸들러로 변환
public class EmpController {

	final EmpMapper mapper; // 위존성 주입(DI, dependency Injection)
	
	// 등록 페이지로 이동
	@GetMapping("/emp/insert")
	public void insert() {
		
	}
	
	// 등록처리 ---> employees 테이블에 photo 컬럼 추가
	@PostMapping("/insert")
	public String insert(EmpVO vo, MultipartFile photoFile) throws IllegalStateException, IOException {
		

		// 파일 d:/upload 경로에 이미지 저장
		File file = new File("d:/upload", photoFile.getOriginalFilename());
		// 파일전송
		photoFile.transferTo(file);
		
		// 파일 업로드
		vo.setPhoto(photoFile.getOriginalFilename());
		
		// 사원정보 + 이미지 DB에저장
		mapper.insertEmp(vo);
		
		return "redirect:/emp/list";
	}
	
	// 수정페이지로 이동
	@GetMapping("/emp/update") // eid=값
	public void update(int eid, Model model) {
		// 단건조회
		EmpVO vo = mapper.getEmpInfo(eid);
		
		// emp/update.html로 데이터 전달
		model.addAttribute("empInfo", vo);		
	}
	
	// 수정처리
	@RequestMapping("/update")
	public String update(EmpVO vo) {
		System.out.println(vo + "=======================");
		mapper.updateEmp(vo);
		
		return "redirect:/emp/list";
	}
	
	// 삭제처리
	@GetMapping("/emp/delete/{employeeId}")
	public String delete(@PathVariable int employeeId, Model model) {
		
		int result = mapper.deleteEmp(employeeId);
		if(result > 0) {
			model.addAttribute("retCode", "OK");		
			return "redirect:/emp/list";
		} else {
			model.addAttribute("retCode", "FAIL");
			return "redirect:/emp/list";
		}
		
	}
	
	// 상세조회 페이지 이동
	@GetMapping("/emp/info/{employeeId}")
	public String empInfo(@PathVariable int employeeId, Model model) {
		EmpVO voInfo = mapper.getEmpInfo(employeeId);
		model.addAttribute("empInfo", voInfo);
		
		return "/emp/info";
	}
	
	// 목록페이지로 이동
	@RequestMapping("/emp/list")
	public String empList(Model model, EmpVO vo, SearchVO svo){ // Model : 데이터 전달자
		System.out.println(vo.getPhoto());
		model.addAttribute("empList", mapper.getEmpList(vo, svo)); // reqest.setAttrubte와 동일
		return "/emp/list"; // forward
	}
	
	
	
	
	
	@GetMapping("/")
	public String test() {
		return "index"; // template/index.html 찾아서 이동
	}


}
