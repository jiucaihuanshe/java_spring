package practice.com.beans;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 快捷键
 * 1)ctrl+shift+t	打开一个查找窗口
 * 2)ctrl+n		打开新建窗口
 * 3)ctrl+t		查看类的继承体系
 * 4)ctrl+o		查看类中的方法，假如想看父类方法继续ctrl+o
 * @author Administrator
 *
 */
public class TestByBeans {
	public static void main(String[] args) {
		/*Calendar c1 = Calendar.getInstance();
		System.out.println(c1);
		Calendar c2 = new GregorianCalendar();
		System.out.println(c2);*/
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Calendar c3 = ctx.getBean("c1", Calendar.class);
		System.out.println(c3);
		Calendar c4 = ctx.getBean("c2", Calendar.class);
		System.out.println(c4);
		ctx.close();
	}

}
