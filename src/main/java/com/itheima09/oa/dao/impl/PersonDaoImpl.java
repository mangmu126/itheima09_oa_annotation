package com.itheima09.oa.dao.impl;

import org.springframework.stereotype.Repository;

import com.itheima09.oa.dao.PersonDao;
import com.itheima09.oa.dao.base.impl.BaseDaoImpl;
import com.itheima09.oa.domain.Person;

@Repository("personDao")
public class PersonDaoImpl extends  BaseDaoImpl<Person> implements PersonDao{
	
}
