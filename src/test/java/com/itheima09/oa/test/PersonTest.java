package com.itheima09.oa.test;

import org.junit.Test;

import com.itheima09.oa.domain.Person;
import com.itheima09.oa.service.PersonService;
import com.itheima09.oa.struts2.action.PersonAction;

public class PersonTest extends SpringUtils{
	@Test
	public void testPersonService(){
		PersonService personService = (PersonService)context.getBean("personService");
		Person person = new Person();
		person.setName("王二麻子");
		person.setDescription("纯爷们");
		personService.saveEntry(person);
	}
	
	@Test
	public void testPersonAction(){
		PersonAction personAction = (PersonAction)context.getBean("personAction");
		System.out.println(personAction);
	}
}
