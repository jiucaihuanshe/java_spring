package practice.com.part.impl;

import practice.com.part.HelloService;

public class HelloServiceImpl implements HelloService{
	/**
	 * ����ҵ�������һ�仰
	 * ���⣺����ڲ��޸�ԭ�д�������ϣ�Ϊ��ҵ�������չ����(�������һ��ʱ��)
	 * ������
	 * 1��ֱ��Ӳ���루Υ��OCP������ά�����ѣ�
	 */
	@Override
	public void sayHello(String msg) {
		//System.out.println(System.nanoTime());
		System.out.println("hello:"+msg);
		//System.out.println(System.nanoTime());
	}
}
