package com.xg.itclassroom.algorithm.design;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyStackTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("setUp");
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
	}

	@Test
	public void testPush() {
		Assert.assertEquals("减法有问题", 10000, 1);
	}

	@Test
	public void testPop() {
		fail("Not yet implemented");
	}

	@Test
	public void testTop() {
		fail("Not yet implemented");
	}

	@Test
	public void testEmpty() {
		fail("Not yet implemented");
	}
	
	@Test
	public void test() {

		int[] x = {0,1,2,3,4,5,6,7};
		
		MyStack stack = new MyStack();
		//添加3个元素
		stack.push(x[0]);
		stack.push(x[1]);
		stack.push(x[2]);
		
		System.out.println( stack.print() );
		Assert.assertEquals("1", stack.top(), x[2]);
		Assert.assertEquals("2", stack.empty(), false);
		
		// 弹出一个元素
		System.out.println( stack.print() );
		Assert.assertEquals("3", stack.pop(), x[2]);
		Assert.assertEquals("4", stack.empty(), false);
		System.out.println( stack.print() );

		// 添加一个元素
		stack.push(x[3]);
		System.out.println( stack.print() );
	}

}
