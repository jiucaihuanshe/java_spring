package practice.com.beans;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class TestGenericDemo01 {
	public static void main(String[] args) throws Exception, Exception {
		//Object[]
		ArrayList<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		//list.add(200);
		
		//获取Class
		Class<?> c= list.getClass();
		//获取Method对象
		Method m=c.getDeclaredMethod("add", Object.class);
		//执行方法
		m.invoke(list, 200);
		System.out.println(list);
	}
}
