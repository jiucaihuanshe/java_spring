package practice.com.beans;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeans {

	public static void main(String[] args) {
		//1.��ʼ��spring�������� 
		//��������û��colse()������������������ʵ�ָ÷���
		//ApplicationContext ctx = 
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//System.out.println(ctx);
		//2.��ȡ������Ҫ�Ķ���
		Date date1 = (Date) ctx.getBean("date1");
		System.out.println(date1);
		//3.�ͷ���Դ
		ctx.close();
	}

}
