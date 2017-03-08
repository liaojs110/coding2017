package com.coding.basic;

import java.util.Arrays;

public class MyArrayList implements List {
	
	private int size = 0;
	
	private Object[] elementData = new Object[100];
	
	public void add(Object o){
		if(size >= elementData.length) {
			elementData = Arrays.copyOf(elementData, elementData.length+100);
		}
		elementData[size++] = o;
	}
	
	public void add(int index, Object o) {
		if(index > size) {
			throw new java.lang.IndexOutOfBoundsException();
		}
		Object[] tmpData;
		if(size >= elementData.length) {
			tmpData = new Object[elementData.length+100];
		} else {
			tmpData = new Object[elementData.length];
		}
		for(int i = 0,j = 0; j < size; i++,j++) {
			if(i == index) i++;
			tmpData[i] = elementData[j];
		}
		tmpData[index] = o;
		elementData = tmpData;
		size++;
	}
	
	public Object get(int index){
		if(index >= size) {
			throw new java.lang.IndexOutOfBoundsException();
		}
		return elementData[index];
	}
	
	public Object remove(int index){
		Object o = get(index);
		for(int i = index; i < size - 1; i++) {
			elementData[i] = elementData[i+1];
		}
		--size;
		return o;
	}
	
	public int size(){
		return size;
	}
	
	public Iterator iterator(){
		return null;
	}
	
}
