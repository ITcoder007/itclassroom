package com.xg.itclassroom.algorithm.paixu;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapRank {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
		
		@Override
		public String toString() {
			return val + " ";
		}
	}

	public static void main(String[] args) {
		/**
[[1,4,5],[1,3,4],[2,6]]
输出
[1,1,2,3,4,4,5,6]
		 */
		ListNode l11 = new ListNode(1);
		ListNode l12 = new ListNode(4);
		ListNode l13 = new ListNode(5);
		l11.next = l12;
		l12.next = l13;
		printArr(l11);
		
		ListNode l21 = new ListNode(1);
		ListNode l22 = new ListNode(3);
		ListNode l23 = new ListNode(4);
		l21.next = l22;
		l22.next = l23;
		printArr(l21);
		
		ListNode l31 = new ListNode(2);
		ListNode l32 = new ListNode(6);
		l31.next = l32;
		printArr(l31);
		
		ListNode[] listNodeArr = new ListNode[] {l11 , l21, l31};
		ListNode mergeKLists = Solution.mergeKLists(listNodeArr);
		
		printArr(mergeKLists);
	}
	
	static void printArr(ListNode node) {
		if(node == null) {
			return;
		}
		
		ListNode cur = node;
		while(cur != null) {
			System.out.print( cur );
			cur = cur.next;
		}
		System.out.println();
	}

	// 合并K个有序链表

	static class Solution {
		public static ListNode mergeKLists(ListNode[] lists) {
			if (lists == null || lists.length == 0) {
				return null;
			}
			// 创建一个小根堆，并定义好排序函数
			PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
				public int compare(ListNode o1, ListNode o2) {
					return (o1.val - o2.val);
				}
			});
			
			// 固定头结点
			ListNode dummy = new ListNode(-1);
			// 移动指针
			ListNode cur = dummy;

			// 建堆： 而是只把k个链表的第一个节点放入到堆中
			for (int i = 0; i < lists.length; i++) {
				ListNode head = lists[i];
				if (head != null) {
					queue.add(head);
				}
			}
			
			// 之后不断从堆中取出节点，如果这个节点还有下一个节点，
			// 就将下个节点也放入堆中
			while (queue.size() > 0) {
				ListNode node = queue.poll();
				cur.next = node;
				cur = cur.next;
				if (node.next != null) {
					queue.add(node.next);
				}
			}
			cur.next = null;
			return dummy.next;
		}
	}

}
