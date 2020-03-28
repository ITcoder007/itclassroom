package com.xg.itclassroom.algorithm.design;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyQueueTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPush() {
		fail("Not yet implemented");
	}

	@Test
	public void testPop() {
		fail("Not yet implemented");
	}

	@Test
	public void testPeek() {
		fail("Not yet implemented");
	}

	@Test
	public void testEmpty() {
		fail("Not yet implemented");
	}
	
	@Test
	public void test() {
		// 准备数据
		int[] input = {0,1,2,3,4,5,6};
		MyQueue myQueue = new MyQueue();
		
		// 入队 3次
		myQueue.push(input[0]);
		myQueue.push(input[1]);
		myQueue.push(input[2]);
		
		// 出队 判定
		System.out.println( myQueue.print() );
		Assert.assertEquals("" , myQueue.pop(), input[0]);
		System.out.println( myQueue.print() );
		
		// 入队一次
		myQueue.push(input[3]);
		System.out.println( myQueue.print() );
		
		// 出队判定
		Assert.assertEquals("" , myQueue.pop(), input[1]);
		System.out.println( myQueue.print() );
	}

}
