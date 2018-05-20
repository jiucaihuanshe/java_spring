package practice.com.beans;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


public class AnnotationTest {
	private static ClassPathXmlApplicationContext ctx;
	static void init(){
		ctx= new ClassPathXmlApplicationContext("annotation.xml");
	}
	static void close(){
		ctx.close();
	}
	public static void main(String[] args) {
		init();
		SysUserService sus = ctx.getBean("sysUserServiceImpl",SysUserService.class);
		System.out.println(sus);
		UserController uc=ctx.getBean("userController",UserController.class);
		System.out.println(uc);
		close();
	}
}
@Service
class SysUserServiceImpl implements SysUserService{
	@Override
	public void saveUser(String user) {
		System.out.println("SysUserServiceImpl.saveUser()");
	}
}
interface SysUserService{
	void saveUser(String user);
}
@Repository
class SysUserDaoImpl implements SysUserDao{
	@Override
	public void insertUser(String user) {
		System.out.println("SysUserDaoImpl.saveUser()");
	}
}
interface SysUserDao{
	void insertUser(String user);
}
@Controller
class UserController{
	
}