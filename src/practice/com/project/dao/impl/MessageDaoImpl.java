package practice.com.project.dao.impl;

import org.springframework.stereotype.Repository;
import practice.com.project.dao.MessageDao;
/** 数据持久层对象(封装JDBC操作的对象)一般会使用@Repository注解修饰 */
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
