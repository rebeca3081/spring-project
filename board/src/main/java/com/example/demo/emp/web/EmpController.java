package com.example.demo.emp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public String insert(@ModelAttribute("emp") EmpVO vo,
						MultipartFile photoFile) {
		// 파일 업로드
		
		vo.setPhoto(photoFile.getOriginalFilename());
		System.out.println(vo);
		mapper.insertEmp(vo);
		return "redirect:/emp/list";
	}
	
	// 수정페이지로 이동
	@GetMapping("/emp/update")
	public void update() {
		
	}
	
	// 수정처리
	
	
	// 삭제처리
	
	
	// 상세조회 페이지 이동
	
	
	// 목록페이지로 이동
	@RequestMapping("/emp/list")
	public String empList(Model model, EmpVO vo, SearchVO svo){ // Model : 데이터 전달자
		System.out.println("tlwkr");
		model.addAttribute("empList", mapper.getEmpList(vo, svo)); // reqest.setAttrubte와 동일
		return "/emp/list"; // forward
	}
	
	@GetMapping("/")
	public String test() {
		return "index"; // template/index.html 찾아서 이동
	}


}
