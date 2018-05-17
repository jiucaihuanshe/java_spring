package practice.com.beans;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import practice.com.project.service.MessageService;

public class TestMessage {
	private static ClassPathXmlApplicationContext ctx;
	static void init(){
		ctx=new ClassPathXmlApplicationContext("beans.xml");
	}
	static void close(){
		ctx.close();
	}
	public static void main(String[] args) {
		init();
		MessageService ms = ctx.getBean("messageServiceImpl",MessageService.class);
		ms.saveMsg("hello gsd1803");
		close();
	}
}
