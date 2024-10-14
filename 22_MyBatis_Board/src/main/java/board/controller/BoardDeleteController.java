package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardDeleteController {
	private final String command = "delete.bd";
	private final String getPage = "boardDeleteForm";
	private final String gotoPage = "redirect:/boardList.bd";
	private final String loginPage = "redirect:/loginForm.mb";
	
	@Autowired
	BoardDao boardDao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public ModelAndView deleteForm(
			@RequestParam(value =  "num", required = true) int num,
			@RequestParam(value = "pageNumber") int pageNumber,
			@RequestParam(value =  "whatColumn", required = false) String whatColumn,
			@RequestParam(value =  "keyword", required = false) String keyword,
			HttpSession session, Model model) { //�ڵ����� ������� ��ü�� session�� ����
		System.out.println(this.getClass() + "(Get) num : " + num +"/pageNumber : "+ pageNumber + "/whatColumn : " + whatColumn + "/keyword : " + keyword);
		
		ModelAndView mav = new ModelAndView();
		System.out.println("loginInfo : " + session.getAttribute("loginInfo")); //���� ���� ���� : null
		if(session.getAttribute("loginInfo") == null) { //�α��� ����
			session.setAttribute("destination", "redirect:/delete.bd?num="+num);
			mav.addObject("pageNumber", pageNumber);
			mav.addObject("whatColumn", whatColumn);
			mav.addObject("keyword", keyword);
			mav.setViewName(loginPage);	
		} else { //�α��� ����			
			BoardBean bb = boardDao.detailArticle(num);
			mav.addObject("board", bb);
			mav.addObject("pageNumber", pageNumber);
			mav.addObject("whatColumn", whatColumn);
			mav.addObject("keyword", keyword);
			mav.setViewName(getPage);
		}
		return mav;
	}
	
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView delete(
			@RequestParam(value =  "num", required = true) int num,
			@RequestParam(value = "pageNumber") int pageNumber,
			@RequestParam(value =  "whatColumn", required = false) String whatColumn,
			@RequestParam(value =  "keyword", required = false) String keyword,
			@RequestParam(value = "passwd") String passwd,
			HttpServletResponse response) throws IOException {
		
		System.out.println("BoardDeleteController post : pageNumber : " + pageNumber + "whatColumn : " + whatColumn + "keyword : " + keyword + "num : " + num);
		
		ModelAndView mav = new ModelAndView();
		String originPasswd = null;
		int cnt = -1;
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out;
		out = response.getWriter();
		BoardBean originArticle = boardDao.detailArticle(num);
		originPasswd = originArticle.getPasswd();
		System.out.println("BoardDeleteController ���� passwd : " + originPasswd);
		System.out.println("�Է��� passwd : " + passwd);
		
		if(originPasswd.equals(passwd)) {
			cnt = boardDao.deleteArticle(num);
			System.out.println("BoardDeleteController cnt : " + cnt);
			System.out.println("���� ����");
			mav.addObject("pageNumber", pageNumber);
			mav.addObject("whatColumn", whatColumn);
			mav.addObject("keyword", keyword);
			mav.setViewName(gotoPage);
		} else {
			mav.addObject("num", num);
			mav.addObject("pageNumber", pageNumber);
			mav.addObject("whatColumn", whatColumn);
			mav.addObject("keyword", keyword);
			
			out.print("<script>alert('��й�ȣ Ʋ��');</script>");
			out.flush();
			
			System.out.println("��й�ȣ �޶� ���� ����");
			mav.setViewName(getPage);
		}
		return mav;
	}
}
