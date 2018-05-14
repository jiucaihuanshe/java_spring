package practice.com.beans;

public class HelloService {
	
	public HelloService() {
		super();
		System.out.println("HelloService()");
	}

	public HelloService(String msg){
		//Class c =Class.forName("practice.com.beans.HelloService");
		//c.newInstance();
		//底层采用这样的方法，默认调用无参构造函数
	}
}
