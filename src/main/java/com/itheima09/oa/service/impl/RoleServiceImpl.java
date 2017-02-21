package com.itheima09.oa.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itheima09.oa.dao.RoleDao;
import com.itheima09.oa.dao.base.BaseDao;
import com.itheima09.oa.domain.Role;
import com.itheima09.oa.service.RoleService;
import com.itheima09.oa.service.base.impl.BaseServiceImpl;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService{

	@Resource(name="roleDao")
	private RoleDao roleDao;
	@Override
	public BaseDao<Role> getBaseDao() {
		// TODO Auto-generated method stub
		return this.roleDao;
	}

}
