package com.sping.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller //@~~ : annotation(���Ͽ� ���� ����)
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET) //method �� ���� value �� ��� ��(/�� get ������� ��û���� �� �Ʒ� �޼��� ����)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate);
		//request.addAttribute("serverTime", formattedDate); �� ���
		//�Ӽ����� ì�ܼ� el�ڵ�� ������ �� �ִٴ� ������
		return "home"; //�߰��κ� >> /WEB-INF/views/home.jsp�� �̵��� ��ġ ����
	} //home
	
	//member ��û�ϸ� view �޼��� ȣ��Ǹ鼭 WEB-INF/views/memberView.jsp�� �̵�
	@RequestMapping("/member") //value �� �ᵵ �� //��û���� �ߺ��Ǹ� �ȵ� //�޼��� �� ���� get, post �� �� ��
	public String view() {
		return "memberView"; //WEB-INF/views/memberView.jsp
	}
	
	@RequestMapping(value="/fruit", method = RequestMethod.GET) //�� get ����� ���� ����
	public String fruit() {
		return "apple";
	}
	
	@RequestMapping("/member/input")
	public String input(Model model) {
		model.addAttribute("id", "kim");
		model.addAttribute("name", "�迬��");
		return "/member/input"; //WEB-INF/views/member/input.jsp
	}
	
	@RequestMapping(value="/member/list", method = RequestMethod.GET) //POST ������� ��û�ϸ� �ȵ�
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "����");
		mav.addObject("age", 30);
		mav.setViewName("/member/list");
		return mav; 
	}
	
	@RequestMapping("member/list2") //�տ� / �� �ٿ��� ��
	public ModelAndView list2() {
		//return "member/list2"; //�տ� / �� �ٿ��� ��
		
		/*
		ModelAndView mav = new ModelAndView(); 
		mav.setViewName("member/list2");
		return mav;
		 */
		
		ModelAndView mav = new ModelAndView("member/list2"); 
		return mav;
	}
	
}
