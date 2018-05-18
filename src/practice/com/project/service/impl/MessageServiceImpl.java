package practice.com.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import practice.com.project.dao.MessageDao;
import practice.com.project.service.MessageService;
/**
 * ͨ��@Autowiredʵ�ֶ�������ֵ��ע�룬Ĭ���ǰ��������ͽ���ֵ��ע�룬���������ṩ��
 * ��������ж�Ӧ��ϵ�Ĺ��캯����ִ��������캯��ֱ�Ӷ����Գ�ʼ�������û�У��ײ�ͨ��
 * ���������������Ժ�Ȼ�������в����������ƥ��Ķ���Ϊ��ע��ֵ��
 * ȱ�ݣ�������ע��ʱ��spring����������ж��ʱ��ע���ʧ��
 * 
 * �������ͽ���ע��ʱ�����������д��ڶ������ͬ�Ķ���ʱ���ܻ�ע��ʧ�ܣ���ʱ�����Խ���
 * @Qualifier ���ע��ָ�������ֽ���ע�롣
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
