package com.itheima09.oa.service;

import java.util.Collection;

import com.itheima09.oa.domain.User;
import com.itheima09.oa.service.base.BaseService;

public interface UserService extends BaseService<User>{
	public Collection<User> getAllUser();
	public void saveUser(User user,Long did,Long[] rids);
}
