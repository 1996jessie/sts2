package mall.cart;

import java.util.*;


public class MyCartList { //��ٱ���
	
	private Map<Integer, Integer> orderLists = null; // n�� ��ǰ m�� �ֹ�(n : key, m : value)

	public MyCartList() {
		orderLists = new HashMap<Integer, Integer>();
	}
	
	public void addOrder(int pnum, int oqty) {
		//���� �ֹ��� ��ǰ
		if(orderLists.containsKey(pnum) == false) { //���� ��ٱ��Ͽ� ������
			orderLists.put(pnum, oqty);
		} else { //���� ��ٱ��Ͽ� ������
			int qty = orderLists.get(pnum);
			orderLists.put(pnum, oqty + qty);
		}

		Set<Integer> key_set = orderLists.keySet();
		System.out.println("key_set : " + key_set); //��ǰ ��ȣ�� ���
		for(int key : key_set) {
			System.out.println(key + ", " + orderLists.get(key));
		}
	}

	public Map<Integer, Integer> getAllOrderLists() {
		// TODO Auto-generated method stub
		return orderLists;
	}



}
