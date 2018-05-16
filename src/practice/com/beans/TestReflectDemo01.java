package practice.com.beans;

import java.lang.reflect.Constructor;

class Point{
	private int x;
	private int y;
	public Point() {
		super();
	}
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}

public class TestReflectDemo01 {
	public static void main(String[] args) throws Exception {
		//��ȡPoint��������(�ֽ������)
		Class<?> c1=Point.class;
		Class<?> c2 =Class.forName("practice.com.beans.Point");
		System.out.println(c1==c2);//true
		
		//���ʵ������(��Ķ���)
		Point p1 =new Point();
		Class<?> c3 = p1.getClass();
		System.out.println(c2==c3);//true
		
		//������Ψһ��
		
		Point p2 =new Point();
		Class<?> c4 = p2.getClass();
		System.out.println(c3==c4);//true
		
		//ͨ������󹹽���Ķ���(ǰ���Ǳ������޲εĹ��캯��)
		Class<?> cc1 = Class.forName("practice.com.beans.Point");
		Point pp1 = (Point) cc1.newInstance();
		
		Constructor<?>[] cs = cc1.getDeclaredConstructors();
		for(Constructor<?> cc : cs){
			//�������󣬻�ȡ���췽��
		}
		
		
		//ͨ��������ȡ��Ĺ��췽������
		Constructor<?> con1 = cc1.getDeclaredConstructor(int.class,int.class);
		//ͨ�����췽�����󹹽���Ķ���
		Point pp2 = (Point) con1.newInstance(10,20);
		
		//System.out.println(pp1);
		//System.out.println(pp2);
	}
}