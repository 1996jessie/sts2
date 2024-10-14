package mall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import member.model.MemberBean;
import order.model.OrderBean;
import order.model.OrderDao;

@Controller
public class OrderMallController {

   private final String command = "order.mall";
   private final String getPage = "shopList";
   private final String gotoPage = "";

   @Autowired
   private OrderDao orderDao;

   //main.jsp ���� '���� �ֹ� ����' Ŭ������ ��
   @RequestMapping(command)
   public String order(HttpSession session, Model model) {

      MemberBean mb = (MemberBean) session.getAttribute("loginInfo");

      if(session.getAttribute("loginInfo") == null) {
         session.setAttribute("destination", "redirect:/order.mall");
         return "redirect:/loginForm.mb";
      } else { //�α��� ����
         List<OrderBean> orderLists = orderDao.getAllMyOrders(mb.getId());
         model.addAttribute("orderLists", orderLists);
         return getPage;
      }
   }
}