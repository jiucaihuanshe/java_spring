package practice.com.part;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import practice.com.part.impl2.UserServiceImpl;
import practice.com.part.interface2.UserService;
/**
 * 动态代理实现（基于JDK）
 * 1）动态代理对象创建说明
 * a)使用动态代理目的是减少自己写代理类过程
 * b)被代理对象要实现了相关接口
 * 2）动态代理对象的创建？
 * 借助Proxy类中的newProxyInstance(...)方法实现动态代理对象与目标对象实现共同接口
 * 3）动态代理应用优势？
 * 不用于自己创建代理类了，代码量会减少
 * 4）动态代理应用劣势？
 * 不好理解，只能为实现了接口的对象创建代理
 */
//动态代理实现
public class TestDyProxy01 {
	
	static class ServiceHandler implements InvocationHandler{
		/**
		 * 定义目标对象的应用
		 * 为什么要关联目标对象？
		 * 因为在handler内部也要处理核心业务
		 */
		private Object target;
		public ServiceHandler(Object target) {
			this.target=target;
		}
		/**
		 * 当我们执行代理对象的业务方法时，底层会自动执行这个handler对象的invoke方法
		 * @param proxy 指向代理对象
		 * @param method 指向接口中的方法对象
		 * @param args 指向method对象执行时需要的实际参数
		 */
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("begin transaction");
			//执行target对象的method方法，传参为args
			Object result = method.invoke(target, args);//核心业务 obj接受的是目标对象
			System.out.println("end transaction");
			return result;
		}
	}
	public static void main(String[] args) {
		//1.目标对象
		UserService userService = new UserServiceImpl();
		//2.为这个目标对象创建一个代理对象
		//2.1获得这个目标类的类加载器对象
		ClassLoader loader = userService.getClass().getClassLoader();
		//2.2获得目标对象实现的接口
		Class<?>[] interfaces =  userService.getClass().getInterfaces();
		//2.3创建一个Handler对象
		ServiceHandler handler = new ServiceHandler(userService);
		//loader目标对象的类加载器
		//interfaces目标对象实现了哪些接口
		//handler业务处理器
		UserService proxy = (UserService) Proxy.newProxyInstance(loader, interfaces, handler);
		//3.执行代理对象业务方法
		proxy.saveUser("京东酒楼");
		//proxy.saveUser("京东酒楼")-->handler.invoke(...) 底层通过反射传过去的
	}
}
