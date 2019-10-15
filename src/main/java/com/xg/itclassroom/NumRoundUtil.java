package com.xg.itclassroom;

public class NumRoundUtil {

	public static void main(String[] args) {
		
		double dou = 3.1487426;
        String douStr = String.format("%.2f", dou);
        System.out.println(douStr);

        douStr = round(dou , 2);
        System.out.println(douStr);
        douStr = round(dou , 3);
        System.out.println(douStr);
        douStr = round(dou , 4);
        System.out.println(douStr);
	}

	/**
	 * 
	 * @param dou 待处理 数字字符串
	 * @param num 保留小数位数
	 * @return
	 */
	private static String round(double dou , Integer num) {
		String format = new StringBuffer().append("%.").append(num).append("f").toString();
		
		String douStr = String.format(format, dou);
		return douStr;
	}
}
