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
 * 使用Component注解修饰的类有spring管理时会为这个bean默认起个名字，
 * 这个名字就是类名的第一个单词的首字母小写，假如希望自己指定名字，需要在
 * 注解中进行配置。
 *
 */

@Scope("singleton")//singleton表示单例
//@Scope("prototype")//prototype表示多例
@Component("idg")//给组件bean起了一个名字
//假如此对象由spring管理，则不采用延迟加载策略
@Lazy(value=false)//false表示不延迟加载
public class IdGenerator {
	//hashMap是一个线程不安全的
	private static Map<String, String> map = new HashMap<>();
	//new Hashtable<>();  这个是线程安全的，但是性能差
	//new ConcurrentHashMap<>();	
	public IdGenerator() {
		System.out.println("IdGenerator.IdGenerator()");
	}
	//加锁，使线程成为线程安全的map
	public synchronized void newId(){
		map.put("", "");
	}
	public synchronized String getId(String key){
		return map.get(key);
	}
	/** 对象构建以后执行(初始化对象) */
	@PostConstruct
	public void init(){
		//将一个线程不安全的map转换为线程安全的map
		map=Collections.synchronizedMap(map);
		//从性能上讲不如ConcurrentHashMap性能高
		System.out.println("IdGenerator.init()");
	}
	/** 对象在销毁之前执行(销毁对象资源) */
	@PreDestroy
	public void destory(){
		System.out.println("IdGenerator.destory()");
		map.clear();
		map=null;
	}
}
//spring中如何优化对象的使用？
//1)单例设计    优化对内存的使用
//2)延迟加载