package practice.com.beans;
/**
 * 何为线程不安全？
 * 多个线程并发访问同一共享数据集时出现的数据不一致
 * 这种线程，称之为线程不安全。例如多个线程卖共同的
 * 100张票出现了重复或者负数时，这就叫做线程不安全。
 * 
 * 出现线程不安全的场景：
 * 1)多个线程并发执行
 * 2)有共享数据集
 * 3)共享数据集上的操作并非是原子操作
 * 
 * 请问servlet的设计默认是单例的吗？
 * 是单例设计
 * 请问servlet中可能存在线程安全问题吗？
 * 可能
 * 请问servlet应用中什么场景下可能会存在线程安全问题？
 * 当servlet中定义了一个实例变量，而这个实例变量的操作又不是原子操作，此时就会出现线程不安全。
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
		//底层采用这样的方法，默认调用无参构造函数
	}
}
