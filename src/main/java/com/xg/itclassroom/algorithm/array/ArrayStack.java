package com.xg.itclassroom.algorithm.array;

import java.util.Arrays;

import com.xg.itclassroom.algorithm.MyStack;

/**
 * 只能在栈顶操作
 * @author gengjiaxing
 *
 */

public class ArrayStack implements MyStack {

	// 数组实例
	private int[] base = new int[10];
	
	// 指向下一个可以存放数据的位置
	int top = 0;
	
	// 初始化方法
	public ArrayStack() {
	}

	public ArrayStack(int length) {
		base = new int[length];
	}
	
	// 入栈
	@Override
	public void push(int element) throws Exception {
		if(base.length == top) {
			throw new Exception();
		}
		base[top++] = element;
	}
	
	// 出栈
	@Override
	public int pop() throws Exception {
		if(top == 0) {
			throw new Exception();
		}
		
		int result = base[--top];
		base[top] = 0;// 原栈顶元素置为0
		
		return result;
	}
	
	@Override
	public String printStack() {
		return Arrays.toString(base);
	}
	
	// 获取栈顶元素，并将元素重新入栈
//	public int popAndPush() throws Exception {
//		int pop = pop();
//		push(pop);
//		
//		return pop;
//	}

//	public int getOnly() throws Exception {
//		if(top == 0) {
//			throw new Exception();
//		}
//		
//		return base[top - 1];
//	}
	
}
