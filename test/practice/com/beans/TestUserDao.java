package practice.com.beans;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import practice.com.project.service.UserService;

public class TestUserDao {
	private static ClassPathXmlApplicationContext ctx;
	static void init(){
		ctx=new ClassPathXmlApplicationContext("beans.xml");
	}
	static void close(){
		ctx.close();
	}
	public static void main(String[] args) {
		init();
		UserService userService = ctx.getBean("userServiceImpl", UserService.class);
		System.out.println(userService);
		userService.saveUser("wangwu");
		close();
	}
}
