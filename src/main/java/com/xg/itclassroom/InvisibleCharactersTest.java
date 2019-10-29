package com.xg.itclassroom;

public class InvisibleCharactersTest {
	public static void main(String[] args) {
		// 1. 
		String m1 , m2;

		m1 = "‮了走地跳跳蹦蹦‭";
		m2 = "蹦蹦跳跳地走了";
		analysis(m1, m2);
		
		System.out.println();
		System.out.println();

		m1 = "13763348417";
		m2 = "13763348417‬";
		analysis(m1, m2);
	}

	private static void analysis(String m1, String m2) {
		System.out.println("m1的长度:" + m1.length());
		System.out.println("m2的长度:" + m2.length());
		
		detail("前者" , m1);
		detail("后者" , m2);
		
		String u1 = string2Unicode(m1);
		System.out.println( u1 );
		String u2 = string2Unicode(m2);
		System.out.println( u2 );
	}

	// 输出每个字节
	private static void detail(String name , String m1) {
		System.out.print(name);

		byte[] bs = m1.getBytes();
		for (byte b : bs) {
			System.out.print(b + " ");
		}
		System.out.println();
		
		char[] charArray = m1.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			System.out.print(charArray[i]);
		}
		System.out.println();
	}
	
	/**
	 * 字符串 转为 Unicode码
	 * @param string
	 * @return
	 */
	public static String string2Unicode(String string) {
		StringBuffer unicode = new StringBuffer();
		for (int i = 0; i < string.length(); i++) {
			// 取出每一个字符
			char c = string.charAt(i);
			// 转换为unicode
			unicode.append("\\u" + Integer.toHexString(c));
		}
 
		return unicode.toString();
	}
	
	/**
	 * Unicode码 转为 字符串
	 * @param unicode
	 * @return
	 */
	public static String unicode2String(String unicode) {
		StringBuffer string = new StringBuffer();
		String[] hex = unicode.split("\\\\u");
 
		for (int i = 1; i < hex.length; i++) {
			// 转换出每一个代码点
			int data = Integer.parseInt(hex[i], 16);
			// 追加成string
			string.append((char) data);
		}
 
		return string.toString();
	}
	
//	/**
//	 * 使用不可见字符，构建 倒置-后坠字符串
//	 * @param s
//	 */
//	private static void buildUnRegularStr(String s) {
//		String pre = "\u202e"; 
//		String u = s;
//		String tail = ""; 
////		String tail = "\u202d"; 
//		
//		String preHandle = new StringBuilder().append(pre).append(u).append(tail).toString();
//		System.out.println( preHandle );
//	}
}
