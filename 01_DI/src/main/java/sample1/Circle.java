package sample1;

public class Circle {
	private double radius;
	/*
	private double xpos; 
	private double ypos;
	*/
	private Point point; //���԰���
	
	public Circle(double radius, Point point) {
		super();
		this.radius = radius;
		this.point = point;
	}
	
	public void display() {
		System.out.println("���� �߽� ��ǥ : " + point.getXpos() + ", " + point.getYpos());
		System.out.println("���� ���� : " + Math.PI * Math.pow(radius,  2.0));
		
	}
}
