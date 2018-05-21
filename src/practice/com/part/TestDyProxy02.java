package practice.com.part;

import java.lang.reflect.Proxy;

import practice.com.part.TestDyProxy01.ServiceHandler;
import practice.com.part.org.OrgService;
import practice.com.part.org.impl.OrgServiceImpl;

public class TestDyProxy02 {
	public static void main(String[] args) {
		//1.Ŀ�����
		OrgServiceImpl orgService = new OrgServiceImpl();
		//2.Ϊ���Ŀ����󴴽�һ���������
		OrgService proxy = (OrgService)Proxy.newProxyInstance(orgService.getClass().getClassLoader(),
				orgService.getClass().getInterfaces(),
				new ServiceHandler(orgService));
		//3.ִ�д������ҵ��
		//Ŀ�����һ��Ҫʵ��һ���ӿڣ���������ӿ�ִ�о����ҵ��
		proxy.saveOrg("������");
	}
}
