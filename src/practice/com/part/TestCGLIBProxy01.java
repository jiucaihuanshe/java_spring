package practice.com.part;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;
/**
 * 动态代理实现（基于CGLIB库，第三方库：别人写好的API）
 * 基于CGLIB库为目标对象创建代理对象时，目标对象可以不实现接口
 * 1）基于CGLIB创建代理的第一步要首先导入包
 * 2）基于CGLIB中的Enhancer创建代理对象
 */

//ctrl+t 查找类的方法
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
		//1.创建目标对象
		MsgService msgService = new MsgService();
		//2.创建代理对象
		//2.1创建一个增强器
		Enhancer e = new Enhancer();
		//设置增强器对于的类的加载器
		e.setClassLoader(msgService.getClass().getClassLoader());
		//设置代理对象要实现的接口或继承的父类
		//当目标对象实现了接口，就用这个方法
		e.setInterfaces(msgService.getClass().getInterfaces());
		
		//当目标对象未实现接口，需要有这个方法
		//e.setSuperclass(msgService.getClass());
		//设置回调接口
		TxMessage tx = new TxMessage();
		e.setCallback(new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				//System.out.println("start");
				tx.begin();
				Object result = method.invoke(msgService, args);//obj 是目标对象
				//System.out.println("end");
				tx.end();
				return null;
			}
		});
		//创建代理对象
		IMessageService proxy = (IMessageService) e.create();
		//这两个类之间存在继承关系，才能进行转型
		//MsgService proxy = (MsgService) e.create();
		//3.执行代理对象业务
		proxy.sendMsg("hello");
	}
}
