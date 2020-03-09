package com.xg.itclassroom.algorithm;

import org.junit.Test;

import com.xg.itclassroom.algorithm.array.ArrayStack;
import com.xg.itclassroom.algorithm.linked.LinkedStack;

public class MyStackTest {

	@Test
	public void test() throws Exception {

		// 数组栈
//		int length =5;
//		MyStack arrayStack = new ArrayStack( length );
//		testStack(arrayStack);
	
		// 链表栈
		LinkedStack linkedStack = new LinkedStack();
		testStack(linkedStack);
		
	}

	private void testStack(MyStack myStack) throws Exception {
		System.out.println("初始化栈···");
		System.out.println("栈内元素是 " + myStack.printStack());
		System.out.println();
		
		// 入栈、入栈
		int ele = 111;
		myStack.push(ele);
		System.out.println("入栈···" + ele);
		System.out.println("栈内元素是 " + myStack.printStack());
		System.out.println();
		
		ele = 222;
		myStack.push(ele);
		System.out.println("入栈···" + ele);
		System.out.println("栈内元素是 " + myStack.printStack());
		System.out.println();
		
		// 出栈
		System.out.println( "出栈···" +myStack.pop() );
		System.out.println("栈内元素是 " + myStack.printStack());
		System.out.println();
	}

}
