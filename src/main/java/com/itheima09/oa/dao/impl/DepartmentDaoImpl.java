package com.itheima09.oa.dao.impl;

import com.itheima09.oa.dao.DepartmentDao;
import com.itheima09.oa.dao.base.impl.BaseDaoImpl;
import com.itheima09.oa.domain.Department;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/2/21.
 */
@Repository("departmentDao")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao {
}
