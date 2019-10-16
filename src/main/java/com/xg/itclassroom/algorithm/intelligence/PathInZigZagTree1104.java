package com.xg.itclassroom.algorithm.intelligence;

import java.util.ArrayList;
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
			再根据label 和 level 获取上层的 label
		
 * @author star
 * @date: Oct 16, 2019
 */
public class PathInZigZagTree1104 {

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
    	
    	Integer level = getLevelBylabel(label);
    	
    	Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
    	
    	for( ;level > 0 ; ) {
    		map.put(level-1, label);
    		// 获取上层的数据
    		label = getUpperLabelByThisLevel(label, level);
    		level--;
    	}
    	
    	List<Integer> list = new ArrayList<Integer>( map.values() );
    	return list;
    }

	private static Integer getUpperLabelByThisLevel(int label, Integer level) {
		Integer order = getOrderByLevel(label, level);
    	
    	// 上层的label 是第几个
    	Integer upperOrder = (order + 1) / 2;
    	// 上层的标号
    	Integer upperLeft = getMostLeftByLevel(level -1);
    	// 从左往右的改变数 -1（递减） ; 1 （递增）
    	Integer upperChangeNum = getChangeNumByLevel(level -1);
    	Integer upperLabel = upperLeft + upperChangeNum * (upperOrder-1);
    	return upperLabel;
	}

	private static Integer getOrderByLevel(int label, Integer level) {
		// 本层是奇数: 从小到大排序； 否则，从大到小
    	Integer left = getMostLeftByLevel(level);
    	// 从左往右的改变数 -1（递减） ; 1 （递增）
    	Integer changeNum = getChangeNumByLevel(level);
    	// 本层是 从左往右第几个
    	Integer order = ((label - left) / changeNum) + 1;
    	return order;
	}
    
    private static Integer getChangeNumByLevel(Integer level) {
		Integer changeNum;
		// 偶数： 从大到小排序
		if (level%2 == 0) {
			changeNum = -1;
		} else {
			changeNum = 1;
		}
		return changeNum;
	}

	private static Integer getMostLeftByLevel(Integer level) {
		Integer left;
		// 偶数： 从大到小排序
		if (level%2 == 0) {
			left = getMaxByLevel(level);
		} else {
			left = getMinByLevel(level);
		}
		return left;
	}

	public static Integer getLevelBylabel( int label ) {
    	Integer level = 0;
		while(true) {
			level++;
			Integer levelMin = getMinByLevel(level);
			Integer levelMax = getMaxByLevel(level);
			if ((levelMin <= label) && (label <= levelMax)) {
				break;
			}
		}
		return level;
    }
    
    /**
     * 根据层级获取 该层最小值
     * @param level
     * @return
     */
    public static Integer getMinByLevel( int level ) {
		Double pow = Math.pow(2, (level - 1));
		int min = pow.intValue();
		return min;
	}

    /**
     * 根据层级获取 该层最大值
     * @param level
     * @return
     */
    public static Integer getMaxByLevel( int level ) {
    	Double pow = Math.pow(2, level) -1;
		int max = pow.intValue();
		return max;
    }
}
