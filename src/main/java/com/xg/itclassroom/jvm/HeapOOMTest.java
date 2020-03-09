package com.xg.itclassroom.jvm;

import java.util.List;

import com.google.common.collect.Lists;

public class HeapOOMTest {

	/**
	 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
	 * @param args
	 * 
	 * 堆溢出解决方案： 
	 * 	内存泄露： 分析 *.hprof文件，查看待回收对象为何没有被回收
	 *  内存溢出：调大 Xmx Xms ; 代码层面检查某些对象生命周期长的问题
	 */
	public static void main(String[] args) {
		
		List<Object> newArrayList = Lists.newArrayList();
		
		while(true) {
			newArrayList.add(new Object());
		}
		
/**
java.lang.OutOfMemoryError: Java heap space
Dumping heap to java_pid32559.hprof ...
Heap dump file created [28974055 bytes in 0.137 secs]
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at java.util.Arrays.copyOf(Arrays.java:3210)
	at java.util.Arrays.copyOf(Arrays.java:3181)
	at java.util.ArrayList.grow(ArrayList.java:265)
	at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:239)
	at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:231)
	at java.util.ArrayList.add(ArrayList.java:462)
	at com.xg.itclassroom.jvm.OutOfMemoryErrorTest.main(OutOfMemoryErrorTest.java:14)

 */
		
	}
	
}
