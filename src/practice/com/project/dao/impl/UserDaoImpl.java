package practice.com.project.dao.impl;

import org.springframework.stereotype.Repository;

import practice.com.project.dao.UserDao;

//@Repository这个类由spring管理
@Repository
public class UserDaoImpl implements UserDao{

	/** 此方法中可以借助jdbc将数据保存到数据库 */
	@Override
	public void insertUser(String user) {
		System.out.println("UserDaoImpl.insertUser()");
	}

}
