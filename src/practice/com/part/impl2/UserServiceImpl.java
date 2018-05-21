package practice.com.part.impl2;

import practice.com.part.interface2.UserService;
/**
 * 要求通过JDK的动态机制，为此类创建代理对象，然后借助代理对象添加扩展业务（例如事务处理）
 * 提示：基于JDK创建代理对象可以采用如下方法
 * Proxy.newProxyInstance(...);
 * 使用此方法时重点在方法参数上（要先理解方法参数的含义）
 */
public class UserServiceImpl implements UserService{

	@Override
	public void saveUser(String user) {
		System.out.println("save user");
	}
	
}
