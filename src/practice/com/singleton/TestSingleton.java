package practice.com.singleton;
/**
 * 设计模式：一种套路，一种经验总结
 * 单例模式：
 * 1）属于一种创建型模式（与对象创建相关）
 * 2）是为了保证类的对象在内存中的全局唯一性，而给定的一种设计规则。
 * 单例模式应用场景：
 * 1）池对象的应用（例如字符串池）
 * 2）资源访问对象
 * 单例模式应用的目的：（减少对象对资源占用）
 * 单例模式的具体实现思路？
 * 规则：
 * 1）类的外部不允许直接构建此类对象
 * 2）类的外部只能通过静态方法访问此对象
 * 实现：
 * 1）构造方法私有化
 * 2）在类的内部构建方法
 * 3）定义一个静态方法，通过这个方法直接返回此对象
 */

//单例设计方案1（单线程下没有任何问题，多线程并发执行出现问题。）
class Singleton01{
	private Singleton01(){}
	private static Singleton01 instance;
	public static Singleton01 getInstance(){//在数据集上的操作不是原子操作
		if(instance==null){//instance是共享数据集
			instance=new Singleton01();
		}
		return instance;
	}
}
//以上单例设计及可能存在什么问题？（线程安全问题）

//单例设计方案2（线程安全单例）
class Singleton02{
	private Singleton02(){}
	private static Singleton02 instance;
	public static synchronized Singleton02 getInstance(){//加锁，线程安全
		if(instance==null){
			instance=new Singleton02();
		}
		return instance;
	}
}
//以上单例设计及可能存在什么问题？（性能问题）

//单例设计方案3（线程安全+效率）(大对象，稀少用)
class Singleton03{
	private Singleton03(){}
	private static Singleton03 instance;
	public static Singleton03 getInstance(){
		if(instance==null){
			synchronized (Singleton03.class) {
				if(instance==null){
					instance=new Singleton03();
				}
			}
		}
		return instance;
	}
}
//以上设计适合对instance对象的频繁访问吗？（不适合）

//单例设计方案4（适合频繁访问）(小对象频繁用)
class Singleton04{
	private Singleton04(){}
	//这个对象何时构建？ 类加载时构建，仅仅会初始化一次
	private static final Singleton04 instance = new Singleton04();
	//此方法因为没有阻塞问题，所以适合频繁访问
	public static Singleton04 getInstance(){
		return instance;
	}
	//public static void display(){}
}
//请问以上设计存在什么问题？（假如对象比较大，类加载时就创建了此对象，假如不适用，就可能长时间占用资源）

//单例设计方案5（采用延迟加载策略优化设计方案4）
class Singleton05{
	private Singleton05(){}
	static class Lazy{//类何时被加载？使用类的时候加载：1、构建类对象时会加载这个类  2、访问类的静态的成员（静态的变量或者静态的方法）
		public static final Singleton05 instance = new Singleton05();
	}
	public static Singleton05 getInstance(){
		//何时需要何时加载
		return Lazy.instance;
	}
	//请问访问Singleton05类的display方法时候会加载Lazy吗？  （不会）
	public static void display(){}
	//请问访问Singleton05类的show方法时候会加载Lazy吗？  （会）
	public void show(){}
}


public class TestSingleton {
	public static void main(String[] args) {
		/*for(int i=0;i<10;i++){
			System.out.println(Singleton01.getInstance());
		}*/
		
		for(int i=0;i<10;i++){
			new Thread(){
				@Override
				public void run() {
					super.run();
					System.out.println(Singleton03.getInstance());
				};
			}.start();
		}
	}
}

//private static volatile Singleton03 instance;
//volatile 有什么作用