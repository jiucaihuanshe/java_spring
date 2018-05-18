package practice.com.project.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import practice.com.project.dao.UserDao;
import practice.com.project.service.UserService;
@Repository
public class UserServiceImpl implements UserService {
	/** 告诉spring帮我为此属性注入值
	 * 	1)UserDao对象由谁创建	spring
	 *	2)userDao这个变量的值由谁进行赋值	spring
	 *	@Resource 注解一般用在属性或set方法上，用于为对象参数赋值，规则是假如这个注解中指定
	 *	了名称，则只按主键中的name属性对应值查找对象，然后进行值的注入。假如注解中没有指定名称，
	 *	先按变量名进行查找，假如没找到，则按类型查找。
	 */
	//@Qualifier("userDaoImpl")
	//@Autowired
	@Resource	//@Resource(name="userDaoImpl")
	private UserDao userDao;
	@Override
	public void saveUser(String user) {
		userDao.insertUser(user);
	}

}
