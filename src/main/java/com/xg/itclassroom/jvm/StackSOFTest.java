package com.xg.itclassroom.jvm;

import java.util.concurrent.atomic.AtomicInteger;

public class StackSOFTest {
	
	private static volatile AtomicInteger i = new AtomicInteger(0);
	
	private void stackLeak(){
		i.incrementAndGet();
		stackLeak();
	}

	/**
	 * -Xss256k
	 * @param args
	 * 
	 * 不能减少线程数的情况下
	 * 
	 * 减少Xmx最大堆容量，减少MaxPermSize最大方法区容量 --> 剩余给 栈
	 */
	public static void main(String[] args) {
		StackSOFTest stackSOFTest = new StackSOFTest();
		
		try {
			stackSOFTest.stackLeak();
		} catch (Throwable e) {
			
			System.out.println(i.get());

			e.printStackTrace();
		}
/**
2818
java.lang.StackOverflowError
	at com.xg.itclassroom.jvm.StackSOFTest.stackLeak(StackSOFTest.java:11)
	at com.xg.itclassroom.jvm.StackSOFTest.stackLeak(StackSOFTest.java:11)
	at com.xg.itclassroom.jvm.StackSOFTest.stackLeak(StackSOFTest.java:11)
	at com.xg.itclassroom.jvm.StackSOFTest.stackLeak(StackSOFTest.java:11)
	at com.xg.itclassroom.jvm.StackSOFTest.stackLeak(StackSOFTest.java:11)
	at com.xg.itclassroom.jvm.StackSOFTest.stackLeak(StackSOFTest.java:11)
	at com.xg.itclassroom.jvm.StackSOFTest.stackLeak(StackSOFTest.java:11)
	at com.xg.itclassroom.jvm.StackSOFTest.stackLeak(StackSOFTest.java:11)
 */
	}
}
