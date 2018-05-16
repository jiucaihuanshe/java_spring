package practice.com.ioc;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestComplex {
	private static ClassPathXmlApplicationContext ctx;
	static void init(){
		ctx=new ClassPathXmlApplicationContext("complex.xml");
	}
	static void close(){
		ctx.close();
	}
	public static void main(String[] args) {
		init();
		ComplexObject obj = ctx.getBean("c",ComplexObject.class);
		String[] hobby = obj.getHobby();
		List<String> address = obj.getAddress();
		Map<String, String> phones =obj.getPhones();
		
		/*Iterator<Map.Entry<String, String>> it = phones.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, String> entry= it.next();
			System.out.println("key="+entry.getKey()+" and value="+entry.getValue());
		}*/
		
		Properties configs = obj.getConfigs();
		
		System.out.println(Arrays.toString(hobby));
		System.out.println(address);
		System.out.println(phones);
		System.out.println(configs);
		close();
	}
}
