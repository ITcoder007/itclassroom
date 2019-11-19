package com.xg.itclassroom.jvm;

public class StackOOMTest {
	
	
	private void oomStack() {
		while(true) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					doSth();
				}
			});
			thread.start();
		}
	}

	protected void doSth() {
		System.out.println(Thread.currentThread().getName());
		while (true) {
		}
	}

	/**
	 * -Xss128k Failed
	 * @param args
	 */
	public static void main(String[] args) {
		new StackOOMTest().oomStack();
	}
}
