package com.tencent.java.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * 数组移除操作
 * http://www.importnew.com/20959.html
 * @author ewanzhao
 *
 */
public class ArrayListRemoveOp {
	
	private static final int EQUAL_NUM = 3;

	public static void main(String[] args) {
		ArrayList<Integer> arrayList = buildArrayList();
		testArrayListRemove(arrayList);    //删除角标的方式删除
		
//		testArrayListRemoveV2(arrayList);
		
//		testArrayListRemoveV3(arrayList);
	}

	/**
	 * 通过迭代器来删除
	 * @param arrayList
	 */
	private static void testArrayListRemoveV3(ArrayList<Integer> arrayList) {
		
		System.out.println("before remove:"+arrayList);
		
		Iterator<Integer> iteratorList = arrayList.iterator();
		while(iteratorList.hasNext()) {
			Integer data = iteratorList.next();
			if(data.equals(EQUAL_NUM)) {
				iteratorList.remove();
			}
		}
		
		System.out.println("after remove:"+arrayList);
		
	}

	/**
	 * 通过迭代器 remove 元素
	 * result:
	 * before remove:[1, 2, 3, 3, 5, 6, 7, 8, 9, 10]
	Exception in thread "main" java.util.ConcurrentModificationException
	at java.util.ArrayList$Itr.checkForComodification(Unknown Source)
	at java.util.ArrayList$Itr.next(Unknown Source)
	at com.tencent.java.collections.ArrayListRemoveOp.testArrayListRemoveV2(ArrayListRemoveOp.java:22)
	at com.tencent.java.collections.ArrayListRemoveOp.main(ArrayListRemoveOp.java:16)
	 * @param arrayList
	 */
	private static void testArrayListRemoveV2(ArrayList<Integer> arrayList) {
		
		System.out.println("before remove:"+arrayList);
		for(Integer integer : arrayList ) {
			if(integer.equals(EQUAL_NUM)) {
				arrayList.remove(integer);
			}
		}
		
		System.out.println("after remove:"+arrayList);
		
	}

	private static ArrayList<Integer> buildArrayList() {
		ArrayList<Integer> arrayList = new ArrayList<>();
		
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(3);
		arrayList.add(5);
		arrayList.add(6);
		arrayList.add(7);
		arrayList.add(8);
		arrayList.add(9);
		arrayList.add(10);
		return arrayList;
	}

	private static void testArrayListRemove(ArrayList<Integer> arrayList) {

		System.out.println("before remove:"+arrayList);
//		for(int i=0; i< arrayList.size(); i++) {
//			if(arrayList.get(i) == 3) {
//				arrayList.remove(i);
//			}
//		}
		
		for(int i=0; i< arrayList.size(); i++) {
			if(arrayList.get(i) == 3) {
				arrayList.remove(i);
				i--;

			}
		}
		
		System.out.println("after remove:"+arrayList);		
		
	}

}
