package com.coderising.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayUtilTest {
	
	ArrayUtil arrayUtil = new ArrayUtil();
	
	public int checkArray(int[] origin, int[] backArray) {
		int i = 0;
		for(int b : backArray) {
			if(b != origin[i]) {
				return 0;
			}
			i++;
		}
		return 1;
	}

	@Test
	public void testReverseArray() {
		int[] origin = {23,0,324,0,3,6,0,2,7,88};
		int[] reverse = arrayUtil.reverseArray(origin);
		int i = origin.length - 1;
		int sign = 1;
		for(int r : reverse) {
			if(r != origin[i]) {
				sign = 0;
				break;
			}
			i--;
		}
		Assert.assertEquals(1, sign);
	}

	@Test
	public void testRemoveZero() {
		int[] oldArray = {23,0,324,0,3,6,0,2,7,88};
		int[] newArray = {23,324,3,6,2,7,88};
		int[] backArray = arrayUtil.removeZero(oldArray);
		Assert.assertEquals(checkArray(newArray,backArray), 1);
	}

	@Test
	public void testMerge() {
		int[] array1 = {22,11,0};
		int[] array2 = {555,12,5,-1};
		int[] mergeArray = {555,22,12,11,5,0,-1};
		int[] backArray = arrayUtil.merge(array1,array2);
		Assert.assertEquals(checkArray(mergeArray,backArray), 1);
	}

	@Test
	public void testGrow() {
		int[] oldArray = {2,3,6};
		int[] newArray = {2,3,6,0,0,0};
		int[] backArray = arrayUtil.grow(oldArray, 3);
		Assert.assertEquals(checkArray(newArray,backArray), 1);
	}

	@Test
	public void testFibonacci() {
		int[] array = {1,1,2,3,5,8,13,21};
		int[] backArray = arrayUtil.fibonacci(26);
		Assert.assertEquals(checkArray(array,backArray), 1);
	}

	@Test
	public void testGetPrimes() {
		int[] array = {2,3,5,7,11,13,17,19};
		int[] backArray = arrayUtil.getPrimes(23);
		Assert.assertEquals(checkArray(array,backArray), 1);
	}

	@Test
	public void testGetPerfectNumbers() {
		int[] array = {8128,496,28,6};
		int[] backArray = arrayUtil.getPerfectNumbers(10000);
		Assert.assertEquals(checkArray(array,backArray), 1);
	}

	@Test
	public void testJoin() {
		int[] array = {3,8,9};
		Assert.assertEquals("3-8-9", arrayUtil.join(array, "-"));
	}

}
