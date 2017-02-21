package com.itheima09.oa.service.impl;

import com.itheima09.oa.dao.DepartmentDao;
import com.itheima09.oa.dao.base.BaseDao;
import com.itheima09.oa.domain.Department;
import com.itheima09.oa.service.DepartmentService;
import com.itheima09.oa.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/2/21.
 */
@Service("departmentService")
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements DepartmentService {
    @Resource(name="departmentDao")
    private DepartmentDao departmentDao;
    @Override
    public BaseDao<Department> getBaseDao() {
        return this.departmentDao;
    }
}
