package com.spring.ex2;

public class OrderImpl implements Order{
	public void order() {
		String msg = "상품 주문";
		System.out.println(msg + "하기"); //핵심 
	}
}
