package sample1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.SessionAttributes;

@Component("PointY")
public class PointY implements Shape{

	public PointY() {
		System.out.println("PointY()");
	}
	
	@Override
	public String make() {
		// TODO Auto-generated method stub
		return "Y�� �����";
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return "Y�� �����";
	}
	
}
