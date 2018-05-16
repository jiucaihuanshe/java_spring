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
		
		//通过类对象构建类的对象(前提是必须有无参的构造函数)
		Class<?> cc1 = Class.forName("practice.com.beans.Point");
		Point pp1 = (Point) cc1.newInstance();
		
		Constructor<?>[] cs = cc1.getDeclaredConstructors();
		for(Constructor<?> cc : cs){
			//根据需求，获取构造方法
		}
		
		
		//通过类对象获取类的构造方法对象
		Constructor<?> con1 = cc1.getDeclaredConstructor(int.class,int.class);
		//通过构造方法对象构建类的对象
		Point pp2 = (Point) con1.newInstance(10,20);
		
		//System.out.println(pp1);
		//System.out.println(pp2);
	}
}