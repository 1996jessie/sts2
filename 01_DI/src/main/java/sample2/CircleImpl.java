package sample2;

public class CircleImpl implements Circle{
	private double radius;
	/*
	private double xpos; 
	private double ypos;
	*/
	private PointImpl point; //���԰���
	
	public CircleImpl(double radius, PointImpl point) {
		super();
		this.radius = radius;
		this.point = point;
	}
	
	public void display() {
		System.out.println("���� �߽� ��ǥ : " + point.getXpos() + ", " + point.getYpos());
		System.out.println("���� ���� : " + Math.PI * Math.pow(radius,  2.0));
		
	}
}

//������ ���ؼ� ������ ����(injection)