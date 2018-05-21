package practice.com.part.impl;

import practice.com.part.HelloService;

public class HelloServiceImpl implements HelloService{
	/**
	 * 核心业务是输出一句话
	 * 问题：如何在不修改原有代码基础上，为此业务添加扩展功能(例如输出一个时间)
	 * 方案：
	 * 1）直接硬编码（违背OCP，代码维护困难）
	 */
	@Override
	public void sayHello(String msg) {
		//System.out.println(System.nanoTime());
		System.out.println("hello:"+msg);
		//System.out.println(System.nanoTime());
	}
}
