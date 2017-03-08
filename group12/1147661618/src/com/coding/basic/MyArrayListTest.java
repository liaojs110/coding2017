package com.coding.basic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyArrayListTest {
	MyArrayList list = null;

	@Before
	public void setUp() throws Exception {
		System.out.println("测试开始！");
        list = new MyArrayList();
        System.out.println("book对象被初始化！");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("book对象将被清理！");
        list = null;
        System.out.println("测试结束！");
	}

	@Test
	public void testAddObject() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
	}

	@Test
	public void testAddIntObject() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(0,99);
		list.add(3,100);
	}

	@Test
	public void testGet() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(0,99);
		list.add(3,100);
		list.get(0);
		list.get(3);
	}

	@Test
	public void testRemove() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(0,99);
		list.add(3,100);
		list.remove(0);
		list.remove(2);
	}

	@Test
	public void testSize() {
		System.out.println(list.size());
	}

	@Test
	public void testIterator() {
		
	}

}
