package sample5;

public class CalcBeanImpl implements CalcBean{

	private int su1;
	private int su2;
	

	public CalcBeanImpl(int su2) {
		super();
		this.su2 = su2;
	}

	public int getSu1() {
		return su1;
	}

	public void setSu1(int su1) {
		this.su1 = su1;
	}

	@Override
	public void calculate() {  
		// TODO Auto-generated method stub
		System.out.println("���� : " + (su1 + su2));
		System.out.println("���� : " + (su1 - su2));
		System.out.println("���� : " + (su1 * su2));
		System.out.println("������ : " + (su1 / su2));
		System.out.println("������ : " + (su1 % su2));
	}

}
