package com.spring.ex1;

public class WorkerImpl implements Worker{

	private String name;
	private int age;
	private String job;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public void getWorkerInfo() { //�ٽ�
		// TODO Auto-generated method stub
		System.out.println("�̸� : " + name);
		System.out.println("���� : " + age);
		System.out.println("���� : " + job);

	}

}