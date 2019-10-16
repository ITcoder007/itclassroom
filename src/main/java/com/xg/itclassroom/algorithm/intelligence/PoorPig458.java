package com.xg.itclassroom.algorithm.intelligence;

/**
	有 1000 只水桶，其中有且只有一桶装的含有毒药，其余装的都是水。它们从外观看起来都一样。如果小猪喝了毒药，它会在 15 分钟内死去。
	问题来了，如果需要你在一小时内，弄清楚哪只水桶含有毒药，你最少需要多少只猪？
	回答这个问题，并为下列的进阶问题编写一个通用算法。
	
	进阶:
		假设有 n 只水桶，猪饮水中毒后会在 m 分钟内死亡，你需要多少猪（x）就能在 p 分钟内找出 “有毒” 水桶？这 n 只水桶里有且仅有一只有毒的桶。
	
	提示：
		可以允许小猪同时饮用任意数量的桶中的水，并且该过程不需要时间。
		小猪喝完水后，必须有 m 分钟的冷却时间。在这段时间里，只允许观察，而不允许继续饮水。
		任何给定的桶都可以无限次采样（无限数量的猪）。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/poor-pigs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

	解法参考: 
		https://blog.csdn.net/lucky52529/article/details/85110278
		
	思路:
		混合水无毒则可以快速验证通过
		思考点: 水桶 - 猪 ， 用猪来找毒水桶
		从猪出发: 每只猪在 1 小时时间内，可以在 0 / 15 / 30 / 45 的时候喝水，并且试探出喝下去水的毒性 
			可以混合喝下多个桶里面的水  
				—— —— 每头猪可以验证 5个桶(5次)的毒性
				—— —— 有几头猪就能验证 5的n次方次毒性。
				如何具体确定它喝哪桶水呢？ 给每个桶进行 五进制编码，每个猪对应一个位数，记录下每个猪死掉的数字，可以最终得到桶的编号。
				
		重点： 十进制编号 与 坐标对应。
		
 * @author star
 * @date: Oct 16, 2019
 */
public class PoorPig458 {
	public static void main(String[] args){
		// 喝毒水后 几分钟死亡
		Integer minutesToDie = 15;
		// 在多少分钟内，找出有毒的水
		Integer maxMinutes = 60;
		
		// 求得最少需要几只猪?
		Integer leastPigs = 1;
		
		// 桶数
//		Integer buckets = 1000;
		for (int buckets = 1; buckets < 1000; buckets++) {
			leastPigs = poorPigs(buckets , minutesToDie , maxMinutes);
			System.out.println( String.format("桶数是 %s , 需要猪的数目是 %s", buckets , leastPigs) );
		}
	}

	public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
		// 参数校验
		if ((buckets <= 0) || (minutesToDie <= 0) || (minutesToTest <= 0) || (minutesToDie > minutesToTest)) {
			return -1;
		}
		
		// 只有一个桶的情况
		if (buckets == 1) {
			return 0;
		}
		
		// 最少猪数 (最少1头)
		Integer num = 1;
		
		// 单独每只猪可以测试几个桶 （进制）
		Integer base = minutesToTest/minutesToDie + 1;
		
		Integer maxAbility = base;
		while ( maxAbility < buckets ) {
			num += 1;
			maxAbility *= base;
		}
		
		return num;
	}
}
