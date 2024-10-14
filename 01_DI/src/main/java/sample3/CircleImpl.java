package sample3;

public class CircleImpl implements Circle{
	private double radius;
	/*
	private double xpos; 
	private double ypos;
	*/
	private PointImpl point; //���԰���
	
	public CircleImpl(double rad, PointImpl point) {
		super();
		this.radius = rad;
		this.point = point;
	}
	
	public void display() {
		System.out.println("���� �߽� ��ǥ : " + point.getXpos() + ", " + point.getYpos());
		System.out.println("���� ���� : " + Math.PI * Math.pow(radius,  2.0));
		
	}
}


//������ ���ؼ� ������ ����(injection)