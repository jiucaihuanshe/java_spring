package practice.com.beans;

class Point{}

public class TestReflectDemo01 {
	public static void main(String[] args) throws Exception {
		//获取Point类的类对象(字节码对象)
		Class<?> c1=Point.class;
		Class<?> c2 =Class.forName("practice.com.beans.Point");
		System.out.println(c1==c2);//true
		
		//类的实例对象(类的对象)
		Point p1 =new Point();
		Class<?> c3 = p1.getClass();
		System.out.println(c2==c3);//true
		
		//对象是唯一的
		
		Point p2 =new Point();
		Class<?> c4 = p2.getClass();
		System.out.println(c3==c4);//true
	}
}
