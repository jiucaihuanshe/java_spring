package practice.com.memory;

class Outer{
	/** 实例内存类：此类对象依赖于外部类对象，默认会保存外部类对象的一个引用 */
	class WorkThread01 extends Thread{
		@Override
		public void run() {
			while(true){}
		}
	}
	
	/** 静态内部类：静态内部类不依赖于外部类而存在，不会保存外部类的引用 */
	//为什么用静态的？原因：可能存在内存泄漏问题，为什么会有内存泄漏，因为实例内部类会保存
	//外部类的一个引用，而实例内部类不销毁的话，会导致外部类不能被销毁，所有就有了内存泄漏
	//的问题
	static class WorkThread02 extends Thread{
		@Override
		public void run() {
			while(true){}
		}
	}
	
	/** 此方法在对象回收之前调用 */
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize()");
	}
}

public class TestMemoryDemo01 {
	public static void main(String[] args) {
		Outer out = new Outer();
		//out.new WorkThread01().start();
		new Outer.WorkThread02().start();
		out = null;
		//通知JVM，内存中有垃圾了，有时间可以过来回收垃圾
		System.gc();
	}
}
