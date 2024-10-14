package com.spring.ex;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ValidController {
	@RequestMapping("form")
	public String form() {
		return "form";
	}
	
	@RequestMapping("insert")
	public String insert(@ModelAttribute("per") @Valid Person ps, BindingResult result) { //result�� ������ �߻��ߴٴ� ������ ����
		System.out.println("result.hasErrors() : " + result.hasErrors()); //false : �� �� ���� �ƴ� / true : �ϳ��� ����
		String page = "result"; //���� ������ result.jsp
		if(result.hasErrors()) { //���� ������ form.jsp
			page = "form";
		}
		return page;
	}
}
