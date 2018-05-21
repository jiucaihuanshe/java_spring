package practice.com.part;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;
/**
 * ��̬����ʵ�֣�����CGLIB�⣬�������⣺����д�õ�API��
 * ����CGLIB��ΪĿ����󴴽��������ʱ��Ŀ�������Բ�ʵ�ֽӿ�
 * 1������CGLIB��������ĵ�һ��Ҫ���ȵ����
 * 2������CGLIB�е�Enhancer�����������
 */

//ctrl+t ������ķ���
interface IMessageService{
	void sendMsg(String msg);
}
class MsgService implements IMessageService{
	public void sendMsg(String msg){
		System.out.println(msg);
	}
}
class TxMessage{
	public void begin(){
		System.out.println("begin transaction");
	}
	public void end(){
		System.out.println("end transaction");
	}
}
public class TestCGLIBProxy01 {
	public static void main(String[] args) {
		//1.����Ŀ�����
		MsgService msgService = new MsgService();
		//2.�����������
		//2.1����һ����ǿ��
		Enhancer e = new Enhancer();
		//������ǿ�����ڵ���ļ�����
		e.setClassLoader(msgService.getClass().getClassLoader());
		//���ô������Ҫʵ�ֵĽӿڻ�̳еĸ���
		//��Ŀ�����ʵ���˽ӿڣ������������
		e.setInterfaces(msgService.getClass().getInterfaces());
		
		//��Ŀ�����δʵ�ֽӿڣ���Ҫ���������
		//e.setSuperclass(msgService.getClass());
		//���ûص��ӿ�
		TxMessage tx = new TxMessage();
		e.setCallback(new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				//System.out.println("start");
				tx.begin();
				Object result = method.invoke(msgService, args);//obj ��Ŀ�����
				//System.out.println("end");
				tx.end();
				return null;
			}
		});
		//�����������
		IMessageService proxy = (IMessageService) e.create();
		//��������֮����ڼ̳й�ϵ�����ܽ���ת��
		//MsgService proxy = (MsgService) e.create();
		//3.ִ�д������ҵ��
		proxy.sendMsg("hello");
	}
}
