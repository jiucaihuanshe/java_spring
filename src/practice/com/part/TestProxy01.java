package practice.com.part;

import practice.com.part.impl.HelloServiceImpl;
import practice.com.part.proxy.HelloServiceProxy;

public class TestProxy01 {
	public static void main(String[] args) {
		//目标对象
		HelloServiceImpl helloService = new HelloServiceImpl();
		//代理对象（扩展的类）
		HelloService helloServiceProxy = new HelloServiceProxy(helloService);
		//HelloServiceProxy helloServiceProxy = new HelloServiceProxy();
		//建立关系
		//helloServiceProxy.setHelloService(helloService);
		//进行访问（调用代理的方法）
		helloServiceProxy.sayHello("王叶");
	}
}
