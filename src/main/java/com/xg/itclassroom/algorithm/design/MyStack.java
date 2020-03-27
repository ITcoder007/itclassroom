package com.xg.itclassroom.algorithm.design;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class MyStack {
	// 双队列实现栈
		// a 入队方式不变； 出队时将size-1的元素移动到另外一个队列b，交换队列引用，b出队 —— 不好，若只是top操作，在进行push操作 事情就会变复杂！！
		// b 出队方式不变； 入队一个元素，将b中元素全部放入a，交换队列引用  —— 将复杂操作放在前面，保持后续各种操作的简洁！！！
	/**
	 * 队列常用操作
	 * 	offer 添加元素到队尾
	 * 	poll 弹出队首元素 
	 * 	peek 查询队首元素 - 偷看
	 * isEmpty
	 */
	
	private Queue<Integer> a ;// 输入队列
	private Queue<Integer> b ;// 输出队列

	public MyStack() {
		a = new LinkedList<Integer>();
		b = new LinkedList<Integer>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		// a 入队一个新元素
		a.offer(x);
		
		// 将 b所有元素排在后面
		while(!b.isEmpty()) {
			a.offer(b.poll());
		}
		
		// 交换队列引用： 保持b为输出队列
		Queue<Integer> temp = a;
		a = b;
		b = temp;
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		return b.poll();
	}

	/** Get the top element. */
	public int top() {
		return b.peek();
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return b.isEmpty();
	}
	
	public String print() {
		
		Integer[] arr = new Integer[b.size()];
		b.toArray(arr);
		
		return Arrays.toString( arr );
	}

}

/**
 * Your MyStack object will be instantiated and called as such: MyStack obj =
 * new MyStack(); obj.push(x); int param_2 = obj.pop(); int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */