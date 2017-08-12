# JUnit使用示例
> 本例要使用到Log4J，现将Log4J配置好

1. 将hamcrest-core-1.3.jar  junit-4.12.jar导入工程中，类似Log4J导入
2. 在测试类中使用，如下代码：
3. 在类中使用，示例代码：

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
