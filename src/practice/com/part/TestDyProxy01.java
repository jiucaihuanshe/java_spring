package practice.com.part;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import practice.com.part.impl2.UserServiceImpl;
import practice.com.part.interface2.UserService;
/**
 * ��̬����ʵ�֣�����JDK��
 * 1����̬������󴴽�˵��
 * a)ʹ�ö�̬����Ŀ���Ǽ����Լ�д���������
 * b)���������Ҫʵ������ؽӿ�
 * 2����̬�������Ĵ�����
 * ����Proxy���е�newProxyInstance(...)����ʵ�ֶ�̬���������Ŀ�����ʵ�ֹ�ͬ�ӿ�
 * 3����̬����Ӧ�����ƣ�
 * �������Լ������������ˣ������������
 * 4����̬����Ӧ�����ƣ�
 * ������⣬ֻ��Ϊʵ���˽ӿڵĶ��󴴽�����
 */
//��̬����ʵ��
public class TestDyProxy01 {
	
	static class ServiceHandler implements InvocationHandler{
		/**
		 * ����Ŀ������Ӧ��
		 * ΪʲôҪ����Ŀ�����
		 * ��Ϊ��handler�ڲ�ҲҪ�������ҵ��
		 */
		private Object target;
		public ServiceHandler(Object target) {
			this.target=target;
		}
		/**
		 * ������ִ�д�������ҵ�񷽷�ʱ���ײ���Զ�ִ�����handler�����invoke����
		 * @param proxy ָ��������
		 * @param method ָ��ӿ��еķ�������
		 * @param args ָ��method����ִ��ʱ��Ҫ��ʵ�ʲ���
		 */
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("begin transaction");
			//ִ��target�����method����������Ϊargs
			Object result = method.invoke(target, args);//����ҵ�� obj���ܵ���Ŀ�����
			System.out.println("end transaction");
			return result;
		}
	}
	public static void main(String[] args) {
		//1.Ŀ�����
		UserService userService = new UserServiceImpl();
		//2.Ϊ���Ŀ����󴴽�һ���������
		//2.1������Ŀ����������������
		ClassLoader loader = userService.getClass().getClassLoader();
		//2.2���Ŀ�����ʵ�ֵĽӿ�
		Class<?>[] interfaces =  userService.getClass().getInterfaces();
		//2.3����һ��Handler����
		ServiceHandler handler = new ServiceHandler(userService);
		//loaderĿ�������������
		//interfacesĿ�����ʵ������Щ�ӿ�
		//handlerҵ������
		UserService proxy = (UserService) Proxy.newProxyInstance(loader, interfaces, handler);
		//3.ִ�д������ҵ�񷽷�
		proxy.saveUser("������¥");
		//proxy.saveUser("������¥")-->handler.invoke(...) �ײ�ͨ�����䴫��ȥ��
	}
}
