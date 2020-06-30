package com.lec.sts12_validation;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec.beans.WriteDTO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@RequestMapping("write.do")
	public String write() {
		
		return "board/write";
	}
	
	@RequestMapping("writeOk.do")
	public String writeOk(@ModelAttribute("w")WriteDTO dto, 
			BindingResult result) { // ◀ validator 가 유효성 검사를 한 결과가 담긴 객체.
		System.out.println("writeOk(): " + dto.getUid() + ":" + dto.getName());
		// System.out.println("에러 개수 : " + result.getErrorCount()); // 바인딩과정에서 발생한 에러 개수
		System.out.print("validate전 "); showErrors(result);
		
		String page = "board/writeOk";

		// validator 객체 생성
		BoardValidator validator = new BoardValidator();
		validator.validate(dto, result);
		System.out.print("validate후 "); showErrors(result);
		
		if(result.hasErrors()) { // 에러가 하나라도 있으면
			page = "board/write"; // 원래 폼으로 다시 돌려보내기
		}
		
		return page;
	}
	
	
	// error 에 담겨 있는 에러들을 다 출력을 도와주는 도우미 함수
	public void showErrors(Errors errors) {
		if(errors.hasErrors()) {
			System.out.println("에러 개수 : " + errors.getErrorCount());
			System.out.println("\t[field]\t|[code]");
			List<FieldError> errList = errors.getFieldErrors();
			for(FieldError err : errList) {
				System.out.println("\t" + err.getField() + "\t|" + err.getCode());
			}
		} else {
			System.out.println("에러 없음");
		}
	}
	
	
}
