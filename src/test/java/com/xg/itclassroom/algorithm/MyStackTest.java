package com.xg.itclassroom.algorithm;

import org.junit.Test;

import com.xg.itclassroom.algorithm.array.ArrayStack;

public class MyStackTest {

	@Test
	public void test() throws Exception {

		// 初始化栈
		int length =5;
		MyStack arrayStack = new ArrayStack( length );
		System.out.println("初始化栈···");
		System.out.println("栈内元素是 " + arrayStack.printStack());
		System.out.println();
		
		// 入栈、入栈
		int ele = 111;
		arrayStack.push(ele);
		System.out.println("入栈···" + ele);
		System.out.println("栈内元素是 " + arrayStack.printStack());
		System.out.println();
		
		ele = 222;
		arrayStack.push(ele);
		System.out.println("入栈···" + ele);
		System.out.println("栈内元素是 " + arrayStack.printStack());
		System.out.println();
		
		// 出栈
		System.out.println( "出栈···" +arrayStack.pop() );
		System.out.println("栈内元素是 " + arrayStack.printStack());
		System.out.println();
	
	}

}
