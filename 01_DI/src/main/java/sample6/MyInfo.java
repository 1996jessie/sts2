package sample6;

public class MyInfo {
	private Person per;
	private Student stu;
	
	public Person getPer() {
		return per;
	}
	public void setPer(Person per) {
		this.per = per;
	}
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	
	public void personPrint() {
		System.out.println("�̸� : " + per.getName());
		System.out.println("���� : " + per.getAge());
		System.out.println("Ű : " + per.getHeight());
		System.out.println("��� : " + per.getHobby());
	}
	
	public void studentPrint() {
		System.out.println("���� : " + stu.getKor());
		System.out.println("���� : " + stu.getEng());
		System.out.println("�̸� : "  + stu.getPer().getName());
		System.out.println("���� : " + stu.getPer().getAge());
		System.out.println("Ű : " + stu.getPer().getHeight());
		System.out.println("��� : " + stu.getPer().getHobby());
	}
}
