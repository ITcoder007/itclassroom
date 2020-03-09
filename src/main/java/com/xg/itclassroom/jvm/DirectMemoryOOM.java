package com.xg.itclassroom.jvm;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

@SuppressWarnings("restriction")
public class DirectMemoryOOM {
	
	private static final int _1MB = 1024*1024*1024;
	
	/**
	 * -Xmx20M -XX:MaxDirectMemorySize=10M
	 * 
	 * Failed
	 * 
	 * @param args
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Field unsafeField = Unsafe.class.getDeclaredFields()[0];
		unsafeField.setAccessible(true);
		Unsafe unsafe = (Unsafe)unsafeField.get(null);
		int i = 0;
		while(true) {
			System.out.println(++i);
			unsafe.allocateMemory(_1MB);
		}
	}

}
