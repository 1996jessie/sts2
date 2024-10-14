package mall.controller;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mall.cart.MyCartList;
import member.model.MemberBean;
import member.model.MemberDao;
import order.model.OrderDao;
import orderdetail.model.OrderDetailBean;
import orderdetail.model.OrderDetailDao;
import product.model.ProductDao;

@Controller
public class CartCalculateController {

	private final String command = "calculate.mall";
	private final String gotoPage = "redirect:/list.prd";
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderDetailDao orderDetailDao;
	
	//mallList.jsp > �����ϱ� Ŭ��
	@RequestMapping(command)
	public String calculate(HttpSession session) {
		
		MemberBean mb = (MemberBean)session.getAttribute("loginInfo");
		
		/* MyCartList mycart = new MyCartList(); : ���ο� ��ٱ��� ��ü ���� */
		
		//CartAddController���� session ����
		MyCartList mycart = (MyCartList)session.getAttribute("mycart"); //���ο� ��ٱ��ϸ� ������ ����
		Map<Integer, Integer> orderLists = mycart.getAllOrderLists();
		
		System.out.println("�ֹ� ���� : " + orderLists.size());
		
		//�ֹ�
		orderDao.insertData(mb.getId());
		int maxOid = orderDao.findMaxOrderOid();
		
		//�ֹ� ������ ����, ���� �ֹ� 
		Set<Integer> key_set = orderLists.keySet();
		for(int pnum : key_set) {
			int qty = orderLists.get(pnum);
			System.out.println("pnum : " + pnum + " / qty : " + qty);
			productDao.updateStock(pnum, qty);
			
			OrderDetailBean odb = new OrderDetailBean();
			odb.setOid(maxOid);
			odb.setPnum(pnum);
			odb.setQty(qty);
			orderDetailDao.insertData(odb);
		}
		
		//ȸ�� ����Ʈ ���� �߰�
		memberDao.updateMpoint(mb.getId(), 100);
		
		session.removeAttribute("mycart");
		return gotoPage;
	}
}
