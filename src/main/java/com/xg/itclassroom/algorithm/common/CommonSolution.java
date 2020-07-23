package com.xg.itclassroom.algorithm.common;

public class CommonSolution {

	/**
	 * 
	 */
	public static void main(String[] args) {
		int titleToNumber = titleToNumber("AB");
		System.out.println( titleToNumber );
	}
	
	public static int getValue(char a) {
		return a - 'A' +1;
	}
	
	public static int getBaseValue(int i){
		if(i==0) {
			return 1;
		}
		int pow = (int)Math.pow(getValue('Z'), i);
		return pow;
	}
	
	public static int titleToNumber(String s) {
		int length = s.length();
		int sum=0;
		for (int i = length-1; i >= 0; i--) {
			char ch = s.charAt(i);
			int value = getValue(ch);
			int baseValue = getBaseValue(i);
			sum += value * baseValue;
		}
		return sum;
    }

}
