/**
 * Copyright (c) 2017, 2020, YCHS-英才汇硕信息科技有限公司. All rights reserved.
 */
package test;

import org.apache.log4j.Logger;

/**
 * Log4J使用示例
 * @author wuzhijun
 * @version 1.0 
 */
public class Student {
    private static Logger logger = Logger.getLogger(Student.class);
    
	public static void main(String[] args) {
	    logger.info(1 - 0.9);	 
	    logger.info("Hello World!");
	}
}
