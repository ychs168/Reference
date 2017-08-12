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
