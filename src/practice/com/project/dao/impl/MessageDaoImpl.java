package practice.com.project.dao.impl;

import org.springframework.stereotype.Repository;
import practice.com.project.dao.MessageDao;
/** ���ݳ־ò����(��װJDBC�����Ķ���)һ���ʹ��@Repositoryע������ */
@Repository
public class MessageDaoImpl implements MessageDao{

	public MessageDaoImpl() {
		System.out.println("MessageDaoImpl.MessageDaoImpl()");
	}
	
	@Override
	public void insertMsg(String msg) {
		System.out.println("dao.msg="+msg);
	}
}
