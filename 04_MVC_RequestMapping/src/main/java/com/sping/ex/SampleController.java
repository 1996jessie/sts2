package com.sping.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample") //���� ��û�� ����
public class SampleController {
	@RequestMapping("/view")
	public String view() {
		return "sample/view"; //���⿡�� �ּ� �� ����� ��
	}
	@RequestMapping("list")
	public String list() {
		return "sample/list";
	}
}
