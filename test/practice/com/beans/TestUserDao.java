package practice.com.beans;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import practice.com.project.dao.UserDao;

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
		UserDao userDao = ctx.getBean("userDaoImpl", UserDao.class);
		System.out.println(userDao);
		close();
	}
}
