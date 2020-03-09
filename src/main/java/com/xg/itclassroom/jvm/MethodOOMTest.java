package com.xg.itclassroom.jvm;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class MethodOOMTest {

	/**
	 * 使用CGLib进行类增强
	 * 
	 * -XX:PermSize=10M -XX:MaxPermSize=10M
	 * 
	 * java8: 
	 * -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			while(true) {
				Enhancer enhancer = new Enhancer();
				enhancer.setSuperclass(OOMObject.class);
				enhancer.setUseCache(false);
				enhancer.setCallback(new MethodInterceptor() {
					@Override
					public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
						return proxy.invokeSuper(obj, args);
					}
				});
				enhancer.create();
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		/**
	java.lang.OutOfMemoryError: Metaspace
		at java.lang.Class.forName0(Native Method)
		at java.lang.Class.forName(Class.java:348)
		at org.springframework.cglib.core.ReflectUtils.defineClass(ReflectUtils.java:467)
		at org.springframework.cglib.core.AbstractClassGenerator.generate(AbstractClassGenerator.java:336)
		at org.springframework.cglib.proxy.Enhancer.generate(Enhancer.java:492)
		at org.springframework.cglib.core.AbstractClassGenerator$ClassLoaderData.get(AbstractClassGenerator.java:114)
		at org.springframework.cglib.core.AbstractClassGenerator.create(AbstractClassGenerator.java:291)
		at org.springframework.cglib.proxy.Enhancer.createHelper(Enhancer.java:480)
		at org.springframework.cglib.proxy.Enhancer.create(Enhancer.java:305)
		at com.xg.itclassroom.jvm.MethodOOMTest.main(MethodOOMTest.java:33)
		 */
	}
	
	static class OOMObject{
	}
}
