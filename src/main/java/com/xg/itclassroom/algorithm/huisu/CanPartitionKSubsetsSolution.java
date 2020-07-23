package com.xg.itclassroom.algorithm.huisu;

import java.util.Arrays;

public class CanPartitionKSubsetsSolution {

	/**
	 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等
	 */
	
	public static void main(String[] args) {
		int[] nums = new int[] {4, 3, 2, 3, 5, 2, 1};
		int k = 4;
		
		boolean res = canPartitionKSubsets(nums, k);
		System.out.println( res );
	}
	
    public static boolean canPartitionKSubsets(int[] nums, int k) {
    	// 求和
    	int sum=0;
    	for (int i : nums) {
			sum+=i;
		}
    	
    	// 确认有整数平均数
    	if(sum % k !=0) {
    		return false;
    	}
    	
    	// 计算平均值
    	int ave = sum/k;
    	
    	// 排序
    	Arrays.sort( nums );
    	System.out.println( Arrays.toString( nums ) );
    	
    	// 保存数字是否使用过的记录
    	boolean[] mark = new boolean[nums.length];
    	for (int i = 0; i < mark.length; i++) {
			mark[i] = false;
		}
    	
    	// 是否存在某个元素等于平均数
    	// 是否有0，或者相加为0的数字
    	// 数组 ， 分为k个， 和为ave 的子数组，记录和判断是否使用过的mark，起始下标
    	
    	// 回溯 ？？？？
    	
		return false;

    }
}
