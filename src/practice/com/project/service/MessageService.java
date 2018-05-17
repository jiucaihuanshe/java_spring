package practice.com.project.service;
/**
 * 业务处理对象
 * 1)核心业务(消息的存储)
 * 2)扩展业务(例如权限处理，日志的处理，事务的处理，缓存的处理)
 */
public interface MessageService {
	void saveMsg(String msg);
}
