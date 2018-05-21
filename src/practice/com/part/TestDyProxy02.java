package practice.com.part;

import java.lang.reflect.Proxy;

import practice.com.part.TestDyProxy01.ServiceHandler;
import practice.com.part.org.OrgService;
import practice.com.part.org.impl.OrgServiceImpl;

public class TestDyProxy02 {
	public static void main(String[] args) {
		//1.目标对象
		OrgServiceImpl orgService = new OrgServiceImpl();
		//2.为这个目标对象创建一个代理对象
		OrgService proxy = (OrgService)Proxy.newProxyInstance(orgService.getClass().getClassLoader(),
				orgService.getClass().getInterfaces(),
				new ServiceHandler(orgService));
		//3.执行代理对象业务
		//目标对象一般要实现一个接口，基于这个接口执行具体的业务
		proxy.saveOrg("教育部");
	}
}
