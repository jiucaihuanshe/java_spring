package practice.com.beans;

import java.util.Date;

import practice.com.factory.ApplicationContext;

class DateUtils{
	/**ͨ�����еľ�̬��������һ������*/
	public static Date getInstance(){
		return new Date();
	}
}

public class TestFactoryDemo01 {

	public static void main(String[] args) {
		//1.ֱ�Ӵ�������(����׶�ȷ��)
		Date date1=new Date();
		//2.ͨ����̬��������
		Date date2=DateUtils.getInstance();
		
		//3.ͨ����̬������������(
		//����������Ϣ�뷴�䴴������)
		//3.1.������������
		ApplicationContext ctx=
		new ApplicationContext("beans.xml");
		//3.2.ͨ����������,��ȡ���ǵĶ���
		Date date3=(Date)ctx.getBean("date1");
		Date date4=
		ctx.getBean("date2",Date.class);
		//3.3.ʹ�ö���
		System.out.println(date3);
		System.out.println(date4);
		//3.4.�رչ�������,�ͷ���Դ
		ctx.close();
	}
	
}
