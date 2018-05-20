package practice.com.beans;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireTest {
	private static ClassPathXmlApplicationContext ctx;
	static void init(){
		ctx = new ClassPathXmlApplicationContext("autowrite.xml");
	}
	static void close(){
		ctx.close();
	}
	public static void main(String[] args) {
		init();
		Test at = ctx.getBean("test",Test.class);
		//System.out.println(at);
		System.out.println("at="+at.getDateSource());
		close();
	}
}

class DateSoruce{
	
}

class Test{
	private DateSoruce dateSource;
	
	public Test() {
		super();
	}

	public Test(DateSoruce dateSource) {
		super();
		this.dateSource = dateSource;
	}

	public void setDateSource(DateSoruce dateSource) {
		this.dateSource = dateSource;
	}

	public DateSoruce getDateSource() {
		return dateSource;
	}
}