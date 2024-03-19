package com.example.demo.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.common.Paging;
import com.example.demo.emp.EmpVO;
import com.example.demo.emp.SearchVO;
import com.example.demo.emp.service.EmpService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller // 컨테이너 빈(Bean) 등록 + 사용자요청처리를 커멘트 핸들러로 변환
public class EmpController {

	final EmpService empService; // 위존성 주입(DI, dependency Injection)
	
	@RequestMapping("/update")
	@ResponseBody  		// request.getParameter
	public String update(@RequestParam List<String> hobby) {
		System.out.println(hobby);
		return "true";
	}

	@RequestMapping("/empList")
	public String empList(Model model, EmpVO vo, SearchVO svo,Paging pvo){ // Model : 데이터 전달자		
		//페이징처리
		pvo.setPageUnit(5); // 페이지당 데이터 수
		pvo.setPageSize(3); // 페이지 번호 수
		svo.setStart(pvo.getFirst());
		svo.setEnd(pvo.getLast());
		
		Map<String, Object> map = empService.getEmpList(vo, svo);
		
		pvo.setTotalRecord((Long)map.get("count")); // 전체건수
		model.addAttribute("paging", pvo);
		
		// 목록조회
		model.addAttribute("empList", map.get("data")); // 리스트
		return "empList"; // forward
	}
	
	@PostMapping("/insert3")
	public String insert3(EmpVO vo, RedirectAttributes rttr) { // redirect rttr이용해서 값을 넘겨줘야 함
		System.out.println("등록 : " + vo);
		rttr.addAttribute("insertResult", "성공");
		rttr.addFlashAttribute("flashResult", "한번만 사용가능");
		// return "result"; // 기본이 forward (주소그대로, 값은 넘김)
		return "redirect:empResult"; // redirect, 등록 후 목록(완전 다른 페이지)으로 이동
	}
	
	@PostMapping("/insert2")
	public ResponseEntity<String> insert2(EmpVO vo) {
		return new ResponseEntity<>("success", HttpStatus.OK); // 200 성공
	}
	
	@PostMapping("/insert") // post인데 get으로 할때(method type이 맞지않을때) 405에러
	public ModelAndView insert(@ModelAttribute("emp") EmpVO vo, Model model) { // 커멘드 객체는 자동으로 모델에 담김!
		System.out.println(vo);
		// mapper.insertEmp(vo); // 등록처리
		
		// @ModelAttribute X 기본 -> VO의 첫글자만 소문자로 변환됨
		// model.addAttribute("empVo", vo);
		
		// 커멘드 객체는 model에 추가되어서 view 페이지로 전달되서 사용가능
		//model.addAttribute("insertResult", "success"); // view 페이지로 결과 전달
		//return "result"; // 페이지 이동
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		mv.addObject("insertResult", "success"); // model.addAttribute();
		mv.setStatus(HttpStatus.INTERNAL_SERVER_ERROR); // 500 Error 상태값 넘겨줄 수 있음
		return mv;
	}
	
	@GetMapping("/info/{empId}")
	public String info(@PathVariable int empId, Model model) {
		System.out.println(empId);
		model.addAttribute("emp", empService.getEmpInfo(empId));
		return "empInfo";
	}
	
	@GetMapping("/update/{empId}")
	public String update(@PathVariable int empId) {
		System.out.println(empId);
		return "empInfo";
	}
	
	@GetMapping("/delete")
	public String delete(int employeeId) {
		empService.deleteEmp(employeeId);
		return "redirect:empList";
	}
	
	@GetMapping("/")
	public String test() {
		return "index"; // template/index.html 찾아서 이동
	}


}
