package com.itheima09.oa.dao;

import java.util.Collection;

import com.itheima09.oa.dao.base.BaseDao;
import com.itheima09.oa.domain.User;

public interface UserDao extends BaseDao<User>{
	public Collection<User> getAllUser();
}
