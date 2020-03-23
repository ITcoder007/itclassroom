package com.xg.itclassroom.algorithm.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RangeSumBSTSolution {

	/**
	 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。 二叉搜索树保证具有唯一的值。
	 */
	public static class TreeNode {
		Integer val;
		TreeNode left;
		TreeNode right;

		TreeNode(Integer x) {
			val = x;
		}
	}

	static List<TreeNode> inputList = new ArrayList<>(); 
	public static void main(String[] args) {

		int L = 6;
		int R = 10;
		Integer[] in = new Integer[] {10,5,15,3,7,13,18,1,null,6};
		
		System.out.println("init " );
		System.out.println(Arrays.toString(in));
		
		for (Integer i : in) {
			if(i!=null) {
				inputList.add(new TreeNode(i));
			}else {
				inputList.add(new TreeNode(null));
			}
		}
		
		// 构建一棵二叉树、按层遍历输出
		TreeNode root = buildTree( );
		print( root );
		
		int sum = rangeSumBST(root, L, R);
		System.out.println();
		System.out.println( sum );
	}

	static List<TreeNode> tempList = new ArrayList<>();
	private static void print(TreeNode root) {
		tempList.add(root);
		while(!tempList.isEmpty()) {
			TreeNode now = tempList.get(0);
			System.out.print(now.val);
			System.out.print("  ");
			if(now.left != null) tempList.add(now.left);
			if(now.right != null) tempList.add(now.right);
			tempList.remove(0);
		}
	}

	// 待初始化左右子树的节点
	static List<TreeNode> list = new ArrayList<>(); 
	private static TreeNode buildTree() {
		// 初始化值
		TreeNode root = inputList.remove(0);
		list.add(root);
		
		// 初始化左右子树
		init2SubTree();
		
		return root;
	}

	private static void init2SubTree() {
		while( inputList.size() > 0 ) {
			TreeNode root = list.remove(0);
			
			TreeNode left = inputList.remove(0);
			root.left = left;
			list.add(left);
			
			if( inputList.size() > 0 ) {
				TreeNode right = inputList.remove(0);
				root.right = right;
				list.add(right);
			}
		}
	}

	static int sum = 0;
	static int numL;
	static int numR;

	public static int rangeSumBST(TreeNode root, int L, int R) {

		numL = L;
		numR = R;

		loop(root);

		return sum;
	}

	private static void loop(TreeNode root) {
		if (root == null || root.val==null) {
			return;
		}

		int val = root.val;
		if (val < numL) {
			loop(root.right);
		} else if (val > numR) {
			loop(root.left);
		} else {
			sum += val;
			loop(root.left);
			loop(root.right);
		}
	}

}
