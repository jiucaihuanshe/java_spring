package practice.com.part.impl2;

import practice.com.part.interface2.UserService;
/**
 * Ҫ��ͨ��JDK�Ķ�̬���ƣ�Ϊ���ഴ���������Ȼ�����������������չҵ������������
 * ��ʾ������JDK�������������Բ������·���
 * Proxy.newProxyInstance(...);
 * ʹ�ô˷���ʱ�ص��ڷ��������ϣ�Ҫ����ⷽ�������ĺ��壩
 */
public class UserServiceImpl implements UserService{

	@Override
	public void saveUser(String user) {
		System.out.println("save user");
	}
	
}
