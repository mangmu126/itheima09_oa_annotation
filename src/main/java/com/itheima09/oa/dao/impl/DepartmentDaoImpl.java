package com.itheima09.oa.dao.impl;

import org.springframework.stereotype.Repository;

import com.itheima09.oa.dao.DepartmentDao;
import com.itheima09.oa.dao.base.impl.BaseDaoImpl;
import com.itheima09.oa.domain.Department;

@Repository("departmentDao")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao{

}
