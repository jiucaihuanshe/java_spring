package practice.com.reflect;

import java.lang.reflect.Method;
import java.util.Scanner;

public class TestReflectDemo01 {
	public static void main(String[] args)throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("please input class");
		String pkgCls = sc.nextLine();
		System.out.println("please input method");
		String methodName =sc.nextLine();
		//1�����������
		Class<?> c= Class.forName(pkgCls);
		//2����ȡ���з�������
		Method m = c.getDeclaredMethod(methodName);
		//3��ִ����Ķ���ķ���
		Object obj= c.newInstance();
		Object result = m.invoke(obj);
		System.out.println(result);
		
		sc.close();
	}
}
