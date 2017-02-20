package com.itheima09.oa.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtils {
	public static ApplicationContext context;
	static{
		context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}
}
