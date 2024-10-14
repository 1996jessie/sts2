package board.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardInsertController {
	final String command = "insert.bd";
	final String getPage = "boardInsertForm";
	final String gotoPage = "redirect:/boardList.bd";
	
	@Autowired
	BoardDao boardDao;
	
	@Autowired
	ServletContext servletContext;
	
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String insert(HttpSession session) { //�ڵ����� ������� ��ü�� session�� ����
		//�α��� �����ϸ� loginInfo ���� ����
		//�ڹٿ����� ServletContext, HttpSession ���
		System.out.println("loginInfo : " + session.getAttribute("loginInfo")); //���� ���� ���� : null
		
		if(session.getAttribute("loginInfo") == null) { //�α��� ����
			session.setAttribute("destination", "redirect:/insert.bd");
			return "redirect:/loginForm.mb";
		} else { //�α��� ����			
			return getPage;
		}
	}
	
	@RequestMapping(value=command, method = RequestMethod.POST)
	public ModelAndView insertArticle(@ModelAttribute("board") @Valid BoardBean bb, BindingResult result, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName(getPage);
			return mav; 
		}
		
		bb.setIp(request.getRemoteAddr());
		
		int cnt = -1;
		cnt = boardDao.insertArticle(bb);
		System.out.println("BoardInsertContoller insertArticle cnt : " + cnt);
		if(cnt != -1) {
			mav.setViewName(gotoPage);
		} else {
			mav.setViewName(getPage);
		}
		return mav;
	
	}
	
}
