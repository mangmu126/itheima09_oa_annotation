package com.itheima09.oa.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itheima09.oa.dao.DepartmentDao;
import com.itheima09.oa.dao.base.BaseDao;
import com.itheima09.oa.domain.Department;
import com.itheima09.oa.service.DepartmentService;
import com.itheima09.oa.service.base.impl.BaseServiceImpl;

@Service("departmentService")
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements DepartmentService{
	@Resource(name="departmentDao")
	private DepartmentDao departmentDao;
	
	@Override
	public BaseDao<Department> getBaseDao() {
		// TODO Auto-generated method stub
		return this.departmentDao;
	}
	
}
