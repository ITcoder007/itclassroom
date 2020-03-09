package com.xg.itclassroom;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class AppTest {
	
	@Test
	public void test() {
		List<String> list = new ArrayList<>(); 
		list.add("1");
		list.add("2");
		
		for (String item : list) { 
			if ("2".equals(item)) {
				list.remove(item);
			}
		}
		
		System.out.println( JSON.toJSONString( list ) );
	}
}
