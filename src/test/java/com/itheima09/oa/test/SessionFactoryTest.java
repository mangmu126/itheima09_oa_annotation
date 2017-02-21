package com.itheima09.oa.test;

import org.hibernate.SessionFactory;
import org.junit.Test;

public class SessionFactoryTest extends SpringUtils{
	@Test
	public void testSessionFactory(){
		SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory");
	}
}
