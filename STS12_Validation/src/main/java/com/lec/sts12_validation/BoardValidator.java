package com.lec.sts12_validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.lec.beans.WriteDTO;

public class BoardValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// 이 validator 가 제공하는 Class 의 인스턴스 (clazz)를 유효성 검사할수 있는가?
		// 검사할 수 있으면 true 아니면 false
		
		// 검증할 객체의 클래스 타입인지 확인 : WriteDTO = clazz; 가능 여부.
		
		return WriteDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// 주어진 객체(target) 에 대한 유효성 검사를 하고
		// 유효성 검사에 오류가 잇는 경우, 주어진 객체에 이 오류들을 errors에 등록한다.
		System.out.println("validate()");
		WriteDTO dto = (WriteDTO)target;
		
		// 수행할 parameter 검증들.
		// 기본적으로 spring이 먼저 validate 를 확인하고 내가 만든거 확인하다
		int uid = dto.getUid();
		if(uid == 0) {
			System.out.println("uid 오류");
			// 에러 등록 rejectValue(field, errorCode)
			errors.rejectValue("uid", "invalidUid");
		}
		
		String name = dto.getName();
		if(name == null || name.trim().isEmpty()) {
			System.out.println("name 오류 : 반드시 한글자라도 입력하세요");
			errors.rejectValue("name", "emptyName");
		}

	}

}
