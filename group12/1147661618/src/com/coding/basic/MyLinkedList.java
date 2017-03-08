package com.coding.basic;

import java.util.LinkedList;

public class MyLinkedList implements List {
	
	private int size = 0;
	private Node head;
	private static class Node{
		Object data;
		Node next;
		
	}
	
	public static void main(String agrs[]) {
		LinkedList list = new LinkedList();
		//System.out.println(list.size());
		
		
		String s[] = new String[5];
		s[0] = "000";
		s[1] = "111";
		s[2] = "222";
		int i = 0;
		do {
			if(s[i++] == null) {
				s[i-1] = "999";
			}
		} while(s[i] != null);
		for(String k:s) {
			System.out.println(k);
		}
	}
	
	public void add(Object o) {
		Node front = head;
		Node tmpNext = null;
		if(head == null) {
			head = new Node();
			head.data = o;
			head.next = null;
		} else {
			while(front.next != null) {
				front = front.next;
			}
		}
		
		
		++size;
	}
	public void add(int index , Object o){
		
	}
	public Object get(int index){
		return null;
	}
	public Object remove(int index){
		return null;
	}
	
	public int size(){
		return size;
	}
	
	public void addFirst(Object o){
		
	}
	public void addLast(Object o){
		
	}
	public Object removeFirst(){
		return null;
	}
	public Object removeLast(){
		return null;
	}
	public Iterator iterator(){
		return null;
	}
	
	
}
