# 开发中如何使用Log4J (1.x)
### 它很重要，没有日志，你将无法工作。恰好它就是帮你做日志的。

> 本示例建立的是纯Java工程，非Web工程；

1. 下载Log4J包 [Log4J官方下载](http://logging.apache.org/log4j/1.2/)
2. 将Log4J的jar包导入到Eclipse工程中，如：log4j-1.2.17.jar(直接将jar包复制到工程目录下，在log4j-1.2.17.jar上右键点击，选择“Build Path”--添加到Build Path)
3. 建立log4j.properties文件，改文件在src目录下，内容如下：

```
log4j.rootLogger= INFO,stdout,D,E
# ERROR   WARN   INFO   DEBUG  : you can set DEBUG when you are debugging program.

### stdout ###
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.Target=System.out
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
#log4j.appender.stdout.layout.ConversionPattern=%d{ABSOLUTE} %5p - %m%n
log4j.appender.stdout.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %p [%c] %l %m%n

log4j.appender.D = org.apache.log4j.FileAppender
log4j.appender.D.File = d:/debug.log
log4j.appender.D.Append = true
log4j.appender.D.Threshold = DEBUG 
log4j.appender.D.layout = org.apache.log4j.PatternLayout
log4j.appender.D.layout.ConversionPattern = %-d{yyyy-MM-dd HH:mm:ss}  [ %t:%r ] - [ %p ]  %m%n

log4j.appender.E = org.apache.log4j.FileAppender
log4j.appender.E.File = d:/error.log 
log4j.appender.E.Append = true
log4j.appender.E.Threshold = ERROR 
log4j.appender.E.layout = org.apache.log4j.PatternLayout
log4j.appender.E.layout.ConversionPattern = %-d{yyyy-MM-dd HH:mm:ss}  [ %t:%r ] - [ %p ]  %m%n
```
4. 在类中使用，示例代码：

```
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
```
在控制台中的输出结果是：

```
2017-08-12 19:11:48 INFO [test.Student] test.Student.main(Student.java:17) 0.09999999999999998
2017-08-12 19:11:48 INFO [test.Student] test.Student.main(Student.java:18) Hello World!
```
> 请仔细分析该结果与log4j.properties中stdout的输出格式设置，也许你就明白了那些符号是什么意思
### 总结
  1. 导入log4j的jar包
  2. 编写log4j.properties文件，放在正确的位置
  3. 在类的属性处定义logger变量
  4. 在需要记录日志的地方调用info()等方法 
  5. 观察日志输出或日志文件，发现程序执行过程行为
  

---
**Log4J日志格式说明**
 log4j.rootLogger=日志级别，appender1, appender2, ….

日志级别：ALL<DEBUG<INFO<WARN<ERROR<FATAL<OFF，不区分大小写
注意，需在控制台输入，只需将其中一个appender定义为stdout即可
注意，rootLogger默认是对整个工程生效
注意，如果只想对某些包操作，那么：log4j.logger.com.ychs=info, stdout，表示该日志对package com.ychs生效
注意，这样做可以区分dev/线上，也可以减小性能影响：if(log.isDebugEnabled()){log.debug();}
  log4j.appender.appender1=org.apache.log4j.日志输出到哪里

ConsoleAppender（控制台）
FileAppender（文件）
DailyRollingFileAppender（每天产生一个日志文件）
RollingFileAppender（文件大小到达指定尺寸时产生一个新的文件）
WriteAppender（将日志信息以流格式发送到任意指定的地方）
JDBCAppender（将日志信息保存到数据库中）


log4j.appender.appender1.File=文件目录及文件

/home/logs/...

 log4j.appender.appender1.MaxFileSize=最大文件大小

 log4j.appender.appender1.MaxBackupIndex=备份文件个数

其中，appender1是在第一行定义过的；
文件目录及文件，例如，/home/admin/logs/oa.log
最大文件大小，例如，100KB
备份文件个数，例如，1
  log4j.appender.ServerDailyRollingFile.DatePattern=日志后缀格式

例如，'.'yyyy-MM-dd
  log4j.appender.appender1.layout=org.apache.log4j.日志布局格式

HTMLLayout（以HTML表格形式布局）
SimpleLayout（包含日志信息的级别和信息字符串）
TTCCLayout（包含日志产生的时间，执行绪，类别等信息）
PatternLayout（可以灵活的指定布局格式--常用）
 log4j.appender.appender1.layout.ConversionPattern=日志输出格式

例如，%d - %m%n或%d{yyyy-MM-dd HH:mm:ss} %p [%c] %m%n
%c 输出日志信息所属的类的全名
%d 输出日志时间点的日期或时间，默认格式为ISO8601，也可以在其后指定格式，比如：%d{yyy-M-dd HH:mm:ss } 
%f 输出日志信息所属的类的类名
%l 输出日志事件的发生位置，即输出日志信息的语句处于它所在的类的第几行
%m 输出代码中指定的信息，如log(message)中的message
%n 输出一个回车换行符，Windows平台为“rn”，Unix平台为“n”
%p 输出优先级，即DEBUG，INFO，WARN，ERROR，FATAL。如果是调用debug()输出的，则为DEBUG，依此类推
%r 输出自应用启动到输出该日志信息所耗费的毫秒数
%t 输出产生该日志事件的线程名
