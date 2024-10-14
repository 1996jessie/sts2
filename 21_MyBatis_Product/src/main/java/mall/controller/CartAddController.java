package mall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mall.cart.MyCartList;
import product.model.ProductBean;

@Controller
public class CartAddController {
	private final String command = "add.mall";
	private final String gotoPage = "redirect:/list.mall";
	
	//productDetailView.jsp���� �ֹ��ϱ� Ŭ���ϸ� num, pageNumber, orderqty ������ �Ѿ��
	@RequestMapping(value=command, method = RequestMethod.POST)
	public String add(ProductBean pb, @RequestParam(value="pageNumber", required = false) int pageNumber, HttpSession session) {
		
		System.out.println(this.getClass() + "Post : " + pb.getNum()+" / "+ pb.getOrderqty() + " / " + pageNumber);
		
		if(session.getAttribute("loginInfo") == null) {
			session.setAttribute("destination", "redirect:/detail.prd?num=" + pb.getNum() + "&pageNumber=" + pageNumber);
			return "redirect:/loginForm.mb";
		} else { //�α��� ����
			
			MyCartList mycart = (MyCartList)session.getAttribute("mycart"); //��ٱ��� ���� �̸� : mycart
			System.out.println("mycart : " + mycart);
			
			if(mycart == null) { //���� ��ٱ��� �� �������
				mycart = new MyCartList(); //��ٱ��� ����� ��
			}
			
			System.out.println("mycart2 : " + mycart); //���� null �ƴ�
			mycart.addOrder(pb.getNum(), pb.getOrderqty());
			session.setAttribute("mycart", mycart); //�� �ٸ� ��ٱ��� ��������� �ʵ���
			return gotoPage;
		}
	}
}
