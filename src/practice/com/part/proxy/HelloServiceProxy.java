package practice.com.part.proxy;

import practice.com.part.HelloService;
/**
 * 静态代理实现：
 * 1）定义一个代理类与目标对象实现共同的接口
 * 抽象角色：interface HelloService(){}
 * 目标对象：class HelloServiceImpl implements HelloService{}
 * 代理对象：class HelloServiceProxy implements HelloService{}
 * 2）实际访问时，在客户端类中访问目标接口，通过目标接口访问代理对象，通过代理对象访问目标对象。
 * 3）静态代理应用场景（小项目，接口少，假如项目比较大，基于每个接口都要自己写一个代理类，可能
 * 工作量也会比较大）
 *
 */
//代理类  静态代理
public class HelloServiceProxy implements HelloService{
	//has a
	private HelloService helloService;
	
	//第2种通过构造方法建立关联
	public HelloServiceProxy(HelloService helloService) {
		this.helloService=helloService;
	}
	
	//第1种：通过set方法建立关联
	/*public void setHelloService(HelloService helloService) {
		this.helloService = helloService;
	}*/

	@Override
	public void sayHello(String msg) {
		System.out.println(System.nanoTime());
		//核心业务
		System.out.println("hello:"+msg);
		System.out.println(System.nanoTime());
	}

}
