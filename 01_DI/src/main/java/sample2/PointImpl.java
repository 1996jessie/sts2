package sample2;

public class PointImpl implements Point{ //�ݵ�� �ϼ��ؾ� �ϴ� �޼��带 ��� ����� �ϼ��ϵ��� �������̽� ���
	private double xpos;
	private double ypos;
	
	public double getXpos() {
		return xpos;
	}
	public void setXpos(double xpos) {
		this.xpos = xpos;
	}
	public double getYpos() {
		return ypos;
	}
	public void setYpos(double ypos) {
		this.ypos = ypos;
	}
	
	//�������̽� ���� �������踦 �����ϰ�(��ȭ) �� �� ����
}

//setter ���� ���� ����(injection)
//�������̽� ���� ��������(dependency) ��ȭ
//DI : Dependency Injection