package practice.com.project.test;

import java.lang.reflect.Field;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

//�õ������Ķ��󣬲�ͨ�����췽����Ҳ��ͨ��set���������ͨ������Ϊ�������ע��һ��ֵ
/*@Component("point")
class Point{
	@Value("5")
	private int x;
	@Value("8")
	private int y;
	public Point() {}
	public Point(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
}*/
class Circle{
	private Point point;
	private int r;
	public void setPoint(Point point) {
		this.point = point;
	}
}


public class TestReflect {
	private static ClassPathXmlApplicationContext ctx;
	static void init(){
		ctx=new ClassPathXmlApplicationContext("beans.xml");
	}
	static void close(){
		ctx.close();
	}
	public static void main(String[] args) {
		/*Point p1=new Point(10,20);
		Circle c=new Circle();
		c.setPoint(p1);*/
		Point p = (Point) ctx.getBean("point");
		System.out.println(p);
	}
}
