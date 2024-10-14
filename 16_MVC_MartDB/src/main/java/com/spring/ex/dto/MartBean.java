package com.spring.ex.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class MartBean {
	private int num;

	@NotEmpty(message = "id �Է� ����")
	private String id;
	
	@NotBlank(message = "pw �Է� ����")
	private String pw;
	
	@NotNull(message = "product �Է� ����")
	private String product;
	
	//@NotEmpty(message = "time �Է� ����")
	@NotBlank(message = "time �Է� ����")
	//@NotNull //�ȵ�
	private String time;
	
	@NotEmpty(message = "approve �Է� ����")
	private String approve;
	
	@NotBlank(message = "agree �Է� ����")
	private String agree;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getApprove() {
		return approve;
	}
	public void setApprove(String approve) {
		this.approve = approve;
	}
	public String getAgree() {
		return agree;
	}
	public void setAgree(String agree) {
		this.agree = agree;
	}
}

/*
text : @NotBlank, @NotEmpty
select : @NotBlank, @NotEmpty
checkbox : @NotNull, @NotBlank, @NotEmpty
radio : @NotNull, @NotBlank, @NotEmpty
*/
