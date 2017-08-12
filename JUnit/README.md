# JUnit使用示例
> 单元测试必须；本例要使用到Log4J，现将Log4J配置好

1. 将hamcrest-core-1.3.jar  junit-4.12.jar导入工程中，类似Log4J导入
2. 要被测试的类，如下代码：
```
/**
 * Copyright (c) 2017, 2018, YCHS-英才汇硕信息科技有限公司. All rights reserved.
 */
package com.ychs.java;

/**
 * 完成两个double型数字的计算
 * 
 * @author wuzhijun
 * @version 1.0  
 */
public class Calc {
	/**
	 * 完成加法计算
	 * 
	 * @param a
	 *            第一个操作数
	 * @param b
	 *            第二个操作数
	 * @return 加法计算得到的结果
	 */
	public double add(int a, int b) {
		return a + b;
	}

	/**
	 * 完成减法计算
	 * 
	 * @param a
	 *            第一个操作数
	 * @param b
	 *            第二个操作数
	 * @return 减法计算得到的结果
	 */
	public double sub(int a, int b) {
		return a - b;
	}

	/**
	 * 完成乘法计算
	 * 
	 * @param a
	 *            第一个操作数
	 * @param b
	 *            第二个操作数
	 * @return 乘法计算得到的结果
	 */
	public double mul(int a, int b) {
		return a * b;
	}

	/**
	 * 完成除法计算
	 * 
	 * @param a
	 *            第一个操作数
	 * @param b
	 *            第二个操作数
	 * @return 除法计算得到的结果
	 */
	public double div(int a, int b) {
		return a / b;
	}

}

```
3. 在测试类中使用，示例代码：

```
/**
 * Copyright (c) 2017, 2020, YCHS-英才汇硕信息科技有限公司. All rights reserved.
 */
package test;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.ychs.java.Calc;

/**
 * JUnit使用示例
 * @author wuzhijun
 * @version 1.0 
 */
public class TestCalc {
	Calc calc = new Calc();
	private static Logger logger = Logger.getLogger(TestCalc.class);
	
	@Test
	public void testAdd(){
		double result = calc.add(3, 5);
		logger.info("加法计算测试结果是： " + result);
	}
	@Test
	public void testSub(){
		double result = calc.sub(3, 5);
		logger.info("减法计算测试结果是： " + result);
	}
	@Test
	public void testMul(){
		double result = calc.mul(3, 5);
		logger.info("乘法计算测试结果是： " + result);
	}
	@Test
	public void testDiv(){
		double result = calc.div(3, 5);
		logger.info("除法计算测试结果是： " + result);
	}
}

```
4. 使用JUnit运行结果
```
2017-08-12 19:52:11 INFO [test.TestCalc] test.TestCalc.testAdd(TestCalc.java:23) 加法计算测试结果是： 8.0
2017-08-12 19:52:11 INFO [test.TestCalc] test.TestCalc.testDiv(TestCalc.java:38) 除法计算测试结果是： 0.0
2017-08-12 19:52:11 INFO [test.TestCalc] test.TestCalc.testMul(TestCalc.java:33) 乘法计算测试结果是： 15.0
2017-08-12 19:52:11 INFO [test.TestCalc] test.TestCalc.testSub(TestCalc.java:28) 减法计算测试结果是： -2.0
```
