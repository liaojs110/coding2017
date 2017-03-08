package com.coderising.litestruts;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectDemo {
	public static void main(String[] args) throws Exception {
		/**
		 * 1.加载Person.class
		 * 2.在内存中开辟空间
		 * 3.对对象中的成员进行默认初始化
		 * 4.显示初始化
		 * 5.构造函数初始化
		 */
	/*	Person p = new Person();
		
		p.show();*/
		
		Class clazz = Class.forName("com.javaForwork.reflect.Person");
		
		/*Method[] methods = clazz.getDeclaredMethods();//可以拿到私有
		methods = clazz.getMethods();//公有成员方法包括继承的
		for(Method method : methods) {
			System.out.println(method);
		}*/
		Constructor constructor = clazz.getConstructor(String.class);
		Person p = (Person)constructor.newInstance("hello");
		//Person p = (Person)clazz.newInstance();
		Method method = clazz.getMethod("show", String.class,int.class);
		
		method.invoke(p, "abc",99);
	}
}
