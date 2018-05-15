package practice.com.beans;

import java.util.Date;
import java.text.SimpleDateFormat;
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
		
		Date c5 = ctx.getBean("date2",Date.class);//返回这类型.class
		System.out.println(c5);
		
		HelloService helloService1 = ctx.getBean("helloService", HelloService.class);
		HelloService helloService2 = ctx.getBean("helloService", HelloService.class);
		
		SimpleDateFormat sdf = new SimpleDateFormat();
		String s = sdf.format(new Date());
		System.out.println("result:"+s);
		
		SimpleDateFormat sdf1 = ctx.getBean("sdf",SimpleDateFormat.class);
		String ss = sdf1.format(new Date());
		System.out.println(ss);
		ctx.close();
	}

}
