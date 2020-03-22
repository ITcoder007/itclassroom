package com.xg.itclassroom.algorithm.common;

import java.util.List;

import org.assertj.core.util.Lists;

public class HanotaSolution {

	public static void main(String[] args) {
		List<Integer> A = Lists.newArrayList(1,0);
		List<Integer> B = Lists.newArrayList();
		List<Integer> C = Lists.newArrayList();
		System.out.println(A);
		System.out.println(B);
		System.out.println(C);
		
		hanota(A, B, C);
		System.out.println(C);
	}
	
    public static void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        // 归纳法 —— 递归
        move(A.size() , A , B , C);
    }

	private static void move(int size, List<Integer> from, List<Integer> mid, List<Integer> to) {
		// n 为 1 ，直接从A 移动到 C
		if(size == 1) {
			to.add( from.remove( from.size() -1 ) );
			return;
		}
		
		// n 大于1， 最后一个以外的移动到B，最后一个移动到C； ···
		move(size-1, from, to, mid);
		move(1, from, mid, to);
		
		move(size-1, mid, from, to);
	}

}
