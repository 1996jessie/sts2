package sample2;

import org.springframework.stereotype.Component;

@Component("PointX") //PointX PointX = new PointX();
public class PointX implements Shape{

	public PointX() {
		System.out.println("PointX()");
	}
	
	@Override
	public String make() {
		// TODO Auto-generated method stub
		return "X�� �����";
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return "X�� �����";
	}

}