package com.xg.itclassroom.algorithm.linked;

import com.xg.itclassroom.algorithm.MyStack;

public class LinkedStack implements MyStack {
	
	private Node head;
	
	private Node top;
	
	// 初始化方法
	public LinkedStack() {
		head = top = new Node(0);
	}

	@Override
	public void push(int element) throws Exception {
		Node node = new Node(element);
		node.prev = top;
		top.next = node;
		
		top = node;
	}

	@Override
	public int pop() throws Exception {
		// 栈空
		if(top.prev == null) {
			throw new Exception();
		}
		
		// 取值，并删除栈顶元素
		int result = top.getData();
		top.prev.next = null;
		
		return result;
	}

	@Override
	public String printStack() {
		if(head == top) {
			return "[]";
		}
		
		Node temp = head;
		StringBuffer result = new StringBuffer("[");
		while(temp.next != null) {
			temp = temp.next;
			result.append(temp.data).append(",");
		}
		result.deleteCharAt(result.length() -1 );
		result.append("]");
		return result.toString();
	}
	
	public static class Node {
		 private int data;
		 
		 private Node next;
		 
		 private Node prev;
		 
		 public Node(int data) {
			 this.data = data;
		 }

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node getPrev() {
			return prev;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}
		 
		 
	}

}
