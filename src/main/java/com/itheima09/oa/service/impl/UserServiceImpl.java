package com.itheima09.oa.service.impl;

import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima09.oa.dao.DepartmentDao;
import com.itheima09.oa.dao.RoleDao;
import com.itheima09.oa.dao.UserDao;
import com.itheima09.oa.dao.base.BaseDao;
import com.itheima09.oa.domain.Department;
import com.itheima09.oa.domain.Role;
import com.itheima09.oa.domain.User;
import com.itheima09.oa.service.UserService;
import com.itheima09.oa.service.base.impl.BaseServiceImpl;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
	@Resource(name="userDao")
	private UserDao userDao;
	@Resource(name="departmentDao")
	private DepartmentDao departmentDao;
	@Resource(name="roleDao")
	private RoleDao roleDao;
	@Override
	public BaseDao<User> getBaseDao() {
		// TODO Auto-generated method stub
		return this.userDao;
	}
	@Override
	public Collection<User> getAllUser() {
		return this.userDao.getAllUser();
	}
	@Transactional
	public void saveUser(User user, Long did, Long[] rids) {
		Department department = this.departmentDao.getEntryById(did);
		//建立用户和部门的关系
		user.setDepartment(department);
		Set<Role> roles = this.roleDao.getEntrysByIds(rids);
		//建立用户和岗位之间的关系
		user.setRoles(roles);
		this.userDao.saveEntry(user);
	}
}
