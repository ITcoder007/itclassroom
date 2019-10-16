package com.xg.itclassroom.algorithm.intelligence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
	在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
	如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
	而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
	
	给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
	
	示例 1：
	输入：label = 14
	输出：[1,3,4,14]
	
	示例 2：
	输入：label = 26
	输出：[1,2,6,10,26]
	 
	提示：
	1 <= label <= 10^6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

	思路:
		先根据label，得出最后一层的层数level；
			再根据label 和 level 获取上层的 label —— 使用传统满二叉树的规律 对称
				位运算 !!
		
 * @author star
 * @date: Oct 16, 2019
 */
public class PathInZigZagTree1104_3 {

	public static void main(String[] args) {
		// 节点标号
		int label = 27;
		
		List<Integer> list = pathInZigZagTree(label);
		
		System.out.println("从根节点到该标号为 label 节点的路径 : ");
		for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
			Integer num = (Integer) iterator.next();
			System.out.println( num );
		}
	}
	
    public static List<Integer> pathInZigZagTree(int label) {
    	
    	List<Integer> list = new ArrayList<Integer>();
    	while (label >= 1) {
    		list.add(label);
    		// 上层节点数字： 根据规律 1. 除以2取整 （右移1位） ； 2. 找树上对称数字： 高位相同，低位取反
    		label = label>>1;
    		
    		// TODO ?????? 位运算 待研究
    		int tmp=Integer.highestOneBit(label) * 2 - 1;
            label=label^(tmp>>1);
            
            
		}
    	
    	Collections.reverse(list);
    	return list;
    }

}
