package practice.com.beans;
/**
 * ��Ϊ�̲߳���ȫ��
 * ����̲߳�������ͬһ�������ݼ�ʱ���ֵ����ݲ�һ��
 * �����̣߳���֮Ϊ�̲߳���ȫ���������߳�����ͬ��
 * 100��Ʊ�������ظ����߸���ʱ����ͽ����̲߳���ȫ��
 * 
 * �����̲߳���ȫ�ĳ�����
 * 1)����̲߳���ִ��
 * 2)�й������ݼ�
 * 3)�������ݼ��ϵĲ���������ԭ�Ӳ���
 * 
 * ����servlet�����Ĭ���ǵ�������
 * �ǵ������
 * ����servlet�п��ܴ����̰߳�ȫ������
 * ����
 * ����servletӦ����ʲô�����¿��ܻ�����̰߳�ȫ���⣿
 * ��servlet�ж�����һ��ʵ�������������ʵ�������Ĳ����ֲ���ԭ�Ӳ�������ʱ�ͻ�����̲߳���ȫ��
 * 
 */
public class HelloService {
	private int count;
	public HelloService() {
		super();
		System.out.println("HelloService()");
	}
	
	public synchronized void count(){
		count++;
	}
	
	public void init(){
		System.out.println("HelloService.init()");
	}
	
	public void destroy(){
		System.out.println("HelloService.destroy()");
	}

	public HelloService(String msg){
		//Class c =Class.forName("practice.com.beans.HelloService");
		//c.newInstance();
		//�ײ���������ķ�����Ĭ�ϵ����޲ι��캯��
	}
}
