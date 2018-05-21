package practice.com.part.proxy;

import practice.com.part.HelloService;
/**
 * ��̬����ʵ�֣�
 * 1������һ����������Ŀ�����ʵ�ֹ�ͬ�Ľӿ�
 * �����ɫ��interface HelloService(){}
 * Ŀ�����class HelloServiceImpl implements HelloService{}
 * �������class HelloServiceProxy implements HelloService{}
 * 2��ʵ�ʷ���ʱ���ڿͻ������з���Ŀ��ӿڣ�ͨ��Ŀ��ӿڷ��ʴ������ͨ������������Ŀ�����
 * 3����̬����Ӧ�ó�����С��Ŀ���ӿ��٣�������Ŀ�Ƚϴ󣬻���ÿ���ӿڶ�Ҫ�Լ�дһ�������࣬����
 * ������Ҳ��Ƚϴ�
 *
 */
//������  ��̬����
public class HelloServiceProxy implements HelloService{
	//has a
	private HelloService helloService;
	
	//��2��ͨ�����췽����������
	public HelloServiceProxy(HelloService helloService) {
		this.helloService=helloService;
	}
	
	//��1�֣�ͨ��set������������
	/*public void setHelloService(HelloService helloService) {
		this.helloService = helloService;
	}*/

	@Override
	public void sayHello(String msg) {
		System.out.println(System.nanoTime());
		//����ҵ��
		System.out.println("hello:"+msg);
		System.out.println(System.nanoTime());
	}

}
