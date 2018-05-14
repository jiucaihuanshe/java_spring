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
		
		//��ȡClass
		Class<?> c= list.getClass();
		//��ȡMethod����
		Method m=c.getDeclaredMethod("add", Object.class);
		//ִ�з���
		m.invoke(list, 200);
		System.out.println(list);
	}
}
