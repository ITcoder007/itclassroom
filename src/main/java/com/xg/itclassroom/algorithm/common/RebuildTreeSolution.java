package com.xg.itclassroom.algorithm.common;

import java.util.HashMap;
import java.util.Map;

public class RebuildTreeSolution {
	
	public static class TreeNode{
		int val;
		
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		int[] preorder = new int[] {3,9,20,15,7};
		int[] inorder = new int[] {9,3,15,20,7};
		
		buildTree(preorder, inorder);
		
	}
	
	static int[] preorders;
	static Map<Integer , Integer> map = new HashMap<>();

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		
		// 先序数组 首节点为根节点 preL; preL+1 ,preL + (gen - inL); preL + (gen - inL)+1,preR
		// 中序数组 被根节点分为左右子树 gen - inL,gen -1 ; gen ; inR - gen, inR；
		// 先序 数组的左右子树元素数目相同 与 中序相同: 
		
		preorders = preorder;
		for (int i =0; i< inorder.length; i++) {
			map.put( inorder[i] , i);
		}
		
		return buildTree(0 , preorder.length-1, 0 , inorder.length-1) ;
	}

	private static TreeNode buildTree(int preL, int preR, int inL, int inR) {
		// 出口
		if(preL>preR || inL>inR){
			return null;
		}
		
		// 根节点值
		int val = preorders[preL];
		TreeNode treeNode = new TreeNode(val);
		
		// 左右子树
		Integer indexIn = map.get(val);
		Integer lNum = indexIn-inL;
		treeNode.left = buildTree(preL+1, preL+lNum, inL, indexIn-1);
		treeNode.right = buildTree(preL+lNum+1, preR, indexIn+1, inR);
		
		return treeNode;
	}
	
}
