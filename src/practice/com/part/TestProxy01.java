package practice.com.part;

import practice.com.part.impl.HelloServiceImpl;
import practice.com.part.proxy.HelloServiceProxy;

public class TestProxy01 {
	public static void main(String[] args) {
		//Ŀ�����
		HelloServiceImpl helloService = new HelloServiceImpl();
		//���������չ���ࣩ
		HelloService helloServiceProxy = new HelloServiceProxy(helloService);
		//HelloServiceProxy helloServiceProxy = new HelloServiceProxy();
		//������ϵ
		//helloServiceProxy.setHelloService(helloService);
		//���з��ʣ����ô���ķ�����
		helloServiceProxy.sayHello("��Ҷ");
	}
}
