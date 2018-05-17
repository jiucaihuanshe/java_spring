package practice.com.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import practice.com.project.util.IdGenerator;

public class TestIdGenerator {
	private static ClassPathXmlApplicationContext ctx;
	
	static void init(){
		ctx= new ClassPathXmlApplicationContext("beans.xml");
	}
	
	public static void close(){
		ctx.close();
	}
	public static void main(String[] args) {
		init();
		/*IdGenerator Generator = ctx.getBean("idg",IdGenerator.class);
		Generator = ctx.getBean("idg",IdGenerator.class);
		System.out.println(Generator);*/
		close();
	}
}
