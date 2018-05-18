package practice.com.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import practice.com.project.dao.MessageDao;
import practice.com.project.service.MessageService;
/**
 * 通过@Autowired实现对象属性值的注入，默认是按属性类型进行值的注入，假如类中提供了
 * 与此属性有对应关系的构造函数则执行这个构造函数直接对属性初始化，如果没有，底层通过
 * 反射获得属性类型以后，然后容器中查找与此类型匹配的对象为其注入值。
 * 缺陷：按类型注入时候，spring管理的类型有多个时候，注入会失败
 * 
 * 当按类型进行注入时，假如容器中存在多个类相同的对象时可能会注入失败，此时还可以借助
 * @Qualifier 这个注解指定按名字进行注入。
 */
@Service
public class MessageServiceImpl implements MessageService {
	//@Qualifier("messageDaoImpl")
	//@Autowired
	private MessageDao msgDao;
	
	
	@Autowired
	public MessageServiceImpl(@Qualifier("messageDaoImpl") MessageDao msgDao) {
		super();
		this.msgDao = msgDao;
		System.out.println("MessageServiceImpl.MessageServiceImpl()");
	}

	@Override
	public void saveMsg(String msg) {
		msgDao.insertMsg(msg);
	}
}
