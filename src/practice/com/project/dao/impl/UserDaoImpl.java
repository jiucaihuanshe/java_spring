package practice.com.project.dao.impl;

import org.springframework.stereotype.Repository;

import practice.com.project.dao.UserDao;

//@Repository�������spring����
@Repository
public class UserDaoImpl implements UserDao{

	/** �˷����п��Խ���jdbc�����ݱ��浽���ݿ� */
	@Override
	public void insertUser(String user) {
		System.out.println("UserDaoImpl.insertUser()");
	}

}
