package com.coderising.array;

import java.util.ArrayList;

public class ArrayUtil {
	
	/**
	 * 给定一个整形数组a , 对该数组的值进行置换
		例如： a = [7, 9 , 30, 3]  ,   置换后为 [3, 30, 9,7]
		如果     a = [7, 9, 30, 3, 4] , 置换后为 [4,3, 30 , 9,7]
	 * @param origin
	 * @return
	 */
	public int[] reverseArray(int[] origin){
		int[] reverseArray = new int[origin.length];
		int j = origin.length - 1;
		for(int i : origin) {
			reverseArray[j--] = i;
		}
		return reverseArray;
	}
	
	/**
	 * 现在有如下的一个数组：   int oldArr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5}   
	 * 要求将以上数组中值为0的项去掉，将不为0的值存入一个新的数组，生成的新数组为：   
	 * {1,3,4,5,6,6,5,4,7,6,7,5}  
	 * @param oldArray
	 * @return
	 */
	
	public int[] removeZero(int[] oldArray){
		int[] tmp = new int[oldArray.length];
		int size = 0;
		for(int i : oldArray) {
			if(i != 0) {
				tmp[size++] = i;
			}
		}
		int[] rtn = new int[size];
		System.arraycopy(tmp, 0, rtn, 0, size);
		return rtn;
	}
	
	/**
	 * 给定两个已经排序好的整形数组， a1和a2 ,  创建一个新的数组a3, 使得a3 包含a1和a2 的所有元素， 并且仍然是有序的
	 * 例如 a1 = [3, 5, 7,8]   a2 = [4, 5, 6,7]    则 a3 为[3,4,5,6,7,8]    , 注意： 已经消除了重复
	 * @param array1
	 * @param array2
	 * @return
	 */
	
	public int[] merge(int[] array1, int[] array2){
		int ascTip = 1;
		if((array1.length >= 2 && array1[0] > array1[1]) || 
				(array2.length >=2 && array2[0] > array2[1])) {
			ascTip = 0;
		}
		int[] mergeArr = new int[array1.length+array2.length];
		for(int i = 0, j = 0, k = 0; i < mergeArr.length; i++) {
			if(j >= array1.length) {
				mergeArr[i] = array2[k++];
			} else {
				mergeArr[i] = array1[j]>array2[k]?(ascTip == 1?array2[k++]:array1[j++]):(ascTip == 1?array1[j++]:array2[k++]);
			}
		}
		return  mergeArr;
	}
	/**
	 * 把一个已经存满数据的数组 oldArray的容量进行扩展， 扩展后的新数据大小为oldArray.length + size
	 * 注意，老数组的元素在新数组中需要保持
	 * 例如 oldArray = [2,3,6] , size = 3,则返回的新数组为
	 * [2,3,6,0,0,0]
	 * @param oldArray
	 * @param size
	 * @return
	 */
	public int[] grow(int [] oldArray,  int size){
		int[] newArray = new int[oldArray.length+size];
		System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
		return newArray;
	}
	
	/**
	 * 斐波那契数列为：1，1，2，3，5，8，13，21......  ，给定一个最大值， 返回小于该值的数列
	 * 例如， max = 15 , 则返回的数组应该为 [1，1，2，3，5，8，13]
	 * max = 1, 则返回空数组 []
	 * @param max
	 * @return
	 */
	public int[] fibonacci(int max){
		if(max <= 1) {
			return null;
		}
		int[] fbtmp = new int[max];
		fbtmp[0] = 1;
		fbtmp[1] = 1;
		int i = 0;
		while(fbtmp[i] + fbtmp[i+1] < max) {
			fbtmp[i+2] = fbtmp[i] + fbtmp[i+1];
			i++;
		}
		int[] rtn = new int[i+2];
		System.arraycopy(fbtmp, 0, rtn, 0, rtn.length);
		return rtn;
	}
	
	/**
	 * 返回小于给定最大值max的所有素数数组
	 * 例如max = 23, 返回的数组为[2,3,5,7,11,13,17,19]
	 * @param max
	 * @return
	 */
	public int[] getPrimes(int max){
		if(max <= 2) {
			return null;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		int prime = 2;
		list.add(prime);
		while(++prime < max) {
			int i = prime - 1;
			while(i >= 2) {
				if(prime%i == 0) {
					break;
				}
				i--;
			}
			if(i <= 1) {
				list.add(prime);
			}
		}
		int[] primes = new int[list.size()];
		int index = 0;
		for(int p : list) {
			primes[index] = p;
			index++;
		}
		return primes;
	}
	
	/**
	 * 所谓“完数”， 是指这个数恰好等于它的因子之和，例如6=1+2+3
	 * 给定一个最大值max， 返回一个数组， 数组中是小于max 的所有完数
	 * @param max
	 * @return
	 */
	public int[] getPerfectNumbers(int max){
		if(max <= 6) {
			return null;
		}
		int tmp[] = new int[max];
		int index = 0;
		int perfectNumber = max-1;
		while(perfectNumber >= 6) {
			int factor = perfectNumber/2==0?perfectNumber/2:perfectNumber/2+1;
			int otherFactor = 2;
			int sumFactor = 1;
			while(factor > otherFactor) {
				if(perfectNumber%factor == 0) {
					sumFactor = sumFactor + factor + perfectNumber/factor;
					otherFactor = perfectNumber/factor;
				} 
				factor--;
				
			}
			if(sumFactor == perfectNumber) {
				tmp[index] = perfectNumber;
				index++;
			}
			perfectNumber--;
		}
		int[] perfectNumbers = new int[index];
		System.arraycopy(tmp, 0, perfectNumbers, 0, index);
		return perfectNumbers;
	}
	
	/**
	 * 用seperator 把数组 array给连接起来
	 * 例如array= [3,8,9], seperator = "-"
	 * 则返回值为"3-8-9"
	 * @param array
	 * @param s
	 * @return
	 */
	public String join(int[] array, String seperator){
		if(array.length <= 1) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		sb.append(array[0]);
		for(int i = 1; i < array.length; i++) {
			sb.append(seperator).append(array[i]);
		}
		return sb.toString();
	}
}





