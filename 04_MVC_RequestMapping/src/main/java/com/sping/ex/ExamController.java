package com.sping.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExamController {
	@RequestMapping("board/form") 
	public String list2() {
		return "form";
	}
	
	/*
	@RequestMapping("/member") //Ŭ������ �޶� �Ȱ��� ��û���� 2�� ������ ����
	public String view() {
		return "form";
	}
	*/
}
