package com.itheima09.oa.struts2.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima09.oa.domain.Person;
import com.itheima09.oa.service.PersonService;
import com.itheima09.oa.service.base.BaseService;
import com.itheima09.oa.struts2.action.base.BaseAction;

@Controller("personAction")
@Scope("prototype")
public class PersonAction extends BaseAction<Person>{
	
	@Resource(name="personService")
	private PersonService personService;

//	@Override
//	public BaseService<Person> getBaseService() {
//		// TODO Auto-generated method stub
//		return this.personService;
//	}

}
