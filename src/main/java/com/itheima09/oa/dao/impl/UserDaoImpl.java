package com.itheima09.oa.dao.impl;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.itheima09.oa.dao.UserDao;
import com.itheima09.oa.dao.base.impl.BaseDaoImpl;
import com.itheima09.oa.domain.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@Override
	public Collection<User> getAllUser() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("from User u");
		stringBuffer.append(" left outer join fetch u.department");
		stringBuffer.append(" left outer join fetch u.roles r");
		return this.hibernateTemplate.find(stringBuffer.toString());
	}

}
