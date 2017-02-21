package com.itheima09.oa.dao.impl;

import org.springframework.stereotype.Repository;

import com.itheima09.oa.dao.RoleDao;
import com.itheima09.oa.dao.base.impl.BaseDaoImpl;
import com.itheima09.oa.domain.Role;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao{

}
