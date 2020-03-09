package com.xg.itclassroom.source;

import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class ConcurrentHashMapTest {

	@Test
	public void testPutIfAbsent() {
		ConcurrentHashMap<String , String> concurrentHashMap = new ConcurrentHashMap<String , String>();
		String absent = concurrentHashMap.putIfAbsent("101", "232");
		System.out.println( absent );
		
		System.out.println( JSON.toJSONString( concurrentHashMap ) );
		
		absent = concurrentHashMap.putIfAbsent("101", "211");
		System.out.println( absent );
		System.out.println( JSON.toJSONString( concurrentHashMap ) );
	}
}
