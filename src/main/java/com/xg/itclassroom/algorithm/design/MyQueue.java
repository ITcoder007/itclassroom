package com.xg.itclassroom.algorithm.design;

import java.util.Arrays;
import java.util.Stack;

class MyQueue {
	
	// 使用两个栈 实现队列
		// 入队行为不变： 出队时，若b为空则将a全部 pop到b中 （否则直接从b弹出元素） 
		// 出队行为不变： 将b数据全部pop到a中，push元素，再将元素全部pop到b —— 较为麻烦
	/**
	 * 常用操作
	 * 	入栈 push
	 * 	出栈 pop
	 * 	读取栈顶元素 peek
	 * 
	 * 	是否为空 empty
	 * 	大小 size
	 */
	
	Stack<Integer> a; // 入队 栈
	Stack<Integer> b; // 出队 栈

    /** Initialize your data structure here. */
    public MyQueue() {
    	a = new Stack<>();
    	b = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    	a.push(x);
    }
     
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	if(b.isEmpty()) {
    		while(!a.isEmpty()) {
    			b.push(a.pop());
    		}
    	}
    	return b.pop();
    }
    
    /** Get the front element. */
    public int peek() {
    	if(b.isEmpty()) {
    		while(!a.isEmpty()) {
    			b.push(a.pop());
    		}
    	}
    	return b.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
    	return a.isEmpty() && b.isEmpty();
    }
    
    public String print() {
    	String aStr = listToString(a);
    	String bStr = listToString(b);
    	
    	return String.format("A: %s B: %s", aStr , bStr);
    }

	@SuppressWarnings({ "unused", "unchecked" })
	private String listToString(Stack stack) {
		Integer[] aArr = new Integer[stack.size()];
    	stack.toArray(aArr);
    	String aStr = Arrays.toString( aArr );
		return aStr;
	}
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */