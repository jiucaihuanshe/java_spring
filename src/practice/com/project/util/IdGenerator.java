package practice.com.project.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
/**
 * ʹ��Componentע�����ε�����spring����ʱ��Ϊ���beanĬ��������֣�
 * ������־��������ĵ�һ�����ʵ�����ĸСд������ϣ���Լ�ָ�����֣���Ҫ��
 * ע���н������á�
 *
 */

@Scope("singleton")//singleton��ʾ����
//@Scope("prototype")//prototype��ʾ����
@Component("idg")//�����bean����һ������
//����˶�����spring�����򲻲����ӳټ��ز���
@Lazy(value=false)//false��ʾ���ӳټ���
public class IdGenerator {
	//hashMap��һ���̲߳���ȫ��
	private static Map<String, String> map = new HashMap<>();
	//new Hashtable<>();  ������̰߳�ȫ�ģ��������ܲ�
	//new ConcurrentHashMap<>();	
	public IdGenerator() {
		System.out.println("IdGenerator.IdGenerator()");
	}
	//������ʹ�̳߳�Ϊ�̰߳�ȫ��map
	public synchronized void newId(){
		map.put("", "");
	}
	public synchronized String getId(String key){
		return map.get(key);
	}
	/** ���󹹽��Ժ�ִ��(��ʼ������) */
	@PostConstruct
	public void init(){
		//��һ���̲߳���ȫ��mapת��Ϊ�̰߳�ȫ��map
		map=Collections.synchronizedMap(map);
		//�������Ͻ�����ConcurrentHashMap���ܸ�
		System.out.println("IdGenerator.init()");
	}
	/** ����������֮ǰִ��(���ٶ�����Դ) */
	@PreDestroy
	public void destory(){
		System.out.println("IdGenerator.destory()");
		map.clear();
		map=null;
	}
}
//spring������Ż������ʹ�ã�
//1)�������    �Ż����ڴ��ʹ��
//2)�ӳټ���