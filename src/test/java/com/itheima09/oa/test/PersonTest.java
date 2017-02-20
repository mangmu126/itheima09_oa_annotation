package com.itheima09.oa.test;

import org.junit.Test;

import com.itheima09.oa.domain.Person;
import com.itheima09.oa.service.PersonService;
import com.itheima09.oa.struts2.action.PersonAction;

public class PersonTest extends SpringUtils{
	@Test
	public void testPersionService()
	{
		PersonService personService = (PersonService) context.getBean("personService");
		Person person = new Person();
		person.setName("王二");
		personService.saveEntry(person);
	}
	
	@Test
	public void testPersionAction()
	{
		PersonAction personAction = (PersonAction)context.getBean("personAction");
		personAction.showDate();
	}
}
