package practice.com.beans;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ��ݼ�
 * 1)ctrl+shift+t	��һ�����Ҵ���
 * 2)ctrl+n		���½�����
 * 3)ctrl+t		�鿴��ļ̳���ϵ
 * 4)ctrl+o		�鿴���еķ����������뿴���෽������ctrl+o
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
