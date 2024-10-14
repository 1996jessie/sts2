package member.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class MemberBean {
	
	@NotBlank(message = "���̵�� �ʼ��� �Է��ؾ� �մϴ�")
	private String id;
	@NotBlank(message = "�̸��� �ʼ��� �Է��ؾ� �մϴ�")
	private String name;
	@NotBlank(message = "��й�ȣ�� �ʼ��� �Է��ؾ� �մϴ�")
	private String password;
	@NotBlank(message = "������ �ʼ��� �Է��ؾ� �մϴ�")
	private String gender;
	@NotBlank(message = "���ɺоߴ� �ʼ��� �Է��ؾ� �մϴ�")
	private String interest;
	@NotBlank(message = "������ �ʼ��� �Է��ؾ� �մϴ�")
	private String job;
	@NotBlank(message = "�ּҴ� �ʼ��� �Է��ؾ� �մϴ�")
	private String address;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
