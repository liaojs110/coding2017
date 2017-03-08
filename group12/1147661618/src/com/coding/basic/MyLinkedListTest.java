package com.coding.basic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyLinkedListTest {
	MyLinkedList list = null;
	@Before
	public void setUp() throws Exception {
		list = new MyLinkedList();
	}

	@After
	public void tearDown() throws Exception {
		list = null;
	}

	@Test
	public void testAddObject() {
		//fail("Not yet implemented");
		System.out.println(list.size());
		list.add("111");
		System.out.println(list.size());
		list.add("222");
		list.add("333");
		System.out.println(list.size());
	}

	/*
	@Test
	public void testAddIntObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	public void testSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddFirst() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddLast() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveFirst() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveLast() {
		fail("Not yet implemented");
	}

	@Test
	public void testIterator() {
		fail("Not yet implemented");
	}
	*/
}
