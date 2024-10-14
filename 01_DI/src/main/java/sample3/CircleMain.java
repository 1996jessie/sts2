package sample3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class CircleMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		double radius = 10.0;
		PointImpl point = new PointImpl();
		
		point.setXpos(3.0);
		point.setYpos(4.0);
		
		CircleImpl circle = new CircleImpl(radius, point);
		circle.display();
		*/
		
		//�� �κ� �� ���� ��ü �� �������
		Resource resource = new ClassPathResource("applicationContext.xml"); //�� ��η� ���� �ʿ��� �ڿ��� �ִ��� ����
		
		BeanFactory factory = new XmlBeanFactory(resource); //bean ���忡�� bean�� 2�� �������
		Circle circle = (Circle) factory.getBean("circle"); //circle�̶�� ���̵�� ������ bean�� �����Ͷ� //Object ���� >> �ٿ�ĳ����
		circle.display();
		
		System.out.println("-----------------------------");
		
		Point point = (Point) factory.getBean("point");
		
		System.out.println("xpos : " + point.getXpos());
		System.out.println("ypos : " + point.getYpos());
		
	}

}

/*
 * IoC(Inversion of Control) : ������ ���� : �������� �������� ������ spring controller�� �ϰ� ��
 */