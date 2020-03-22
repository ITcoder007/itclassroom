package com.xg.itclassroom.algorithm.common;

public class NumWaysSolution {
	/**
	 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
	 * @param args
	 */
	
	public static void main(String[] args) {
		System.out.println( numWays(2) );
		System.out.println( numWays(7) );
	}
	
    public static int numWays(int n) {
    	// n 为 1，有1种跳法
    	//      2   2
    	//      3   3
    	//      4   5
    	
    	//假设 n 个台阶，有 f(n)种跳法
    	
    	// 迭代递推公式: f(n) = f(n-1) + f(n-2) 
    	// 0  1  2  3  4  5  6
    	// 1  1  2  3  5  8  13
    	if(n==0) return 1;
    	if(n==1) return 1;
    	
    	int a =1;
    	int b =1;
    	int sum =0;
    	for(int i=1; i< n; i++) {
    		sum = a+b;
    		a = b;
    		b = sum;
    	}
    	
    	return sum;
    }
    
//    static Map<Integer, Integer> map = new HashMap<>(); 
//    
//    public static int numWays(int n) {
//    	// n 为 1，有1种跳法
//    	//      2   2
//    	//假设 n 个台阶，有 f(n)种跳法
//    	// f(n) = f(n-1) + f(n-2) 
//    	
//    	if(n == 1) return 1;
//    	if(n == 2) return 2;
//    	
//    	// 改进： 记忆化递归
//    	if(map.get(n) != null) {
//    		return map.get(n);
//    	}else {
//    		int res = numWays(n-1) + numWays(n-2);
//    		map.put(n, res);
//    		return res;
//    	}
//    	
//    	// 尾递归， 改造为 迭代
//    }
}
