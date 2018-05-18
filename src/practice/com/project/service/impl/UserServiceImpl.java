package practice.com.project.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import practice.com.project.dao.UserDao;
import practice.com.project.service.UserService;
@Repository
public class UserServiceImpl implements UserService {
	/** ����spring����Ϊ������ע��ֵ
	 * 	1)UserDao������˭����	spring
	 *	2)userDao���������ֵ��˭���и�ֵ	spring
	 *	@Resource ע��һ���������Ի�set�����ϣ�����Ϊ���������ֵ�������Ǽ������ע����ָ��
	 *	�����ƣ���ֻ�������е�name���Զ�Ӧֵ���Ҷ���Ȼ�����ֵ��ע�롣����ע����û��ָ�����ƣ�
	 *	�Ȱ����������в��ң�����û�ҵ��������Ͳ��ҡ�
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
