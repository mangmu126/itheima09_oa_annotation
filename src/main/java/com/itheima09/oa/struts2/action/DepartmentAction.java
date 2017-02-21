package com.itheima09.oa.struts2.action;

import com.itheima09.oa.domain.Department;
import com.itheima09.oa.service.DepartmentService;
import com.itheima09.oa.struts2.action.base.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import org.codehaus.jackson.map.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collection;

@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department>{
    @Resource(name="departmentService")
    private DepartmentService departmentService;

    /**
     * 查询所有的数据
     */
    public String showAllDepartment()
    {
        Collection<Department> departmentsList = this.departmentService.queryEntry();
        ActionContext.getContext().put("departmentList",departmentsList);
        return listAction;
    }

    public String updateUI()
    {
        // 根据id把要回现的数据提取出来
        Department department = this.departmentService.getEntryById(this.getModel().getDid());
        ActionContext.getContext().getValueStack().push(department);
        return updateUI;
    }

    public String update()
    {
        /**
         * 1、根据id把department对象提取出来
         * 2、把模型驱动中的值赋值给department对象
         * 3、执行update操作
         */
        Department department = this.departmentService.getEntryById(this.getModel().getDid());
        BeanUtils.copyProperties(this.getModel(),department);
        this.departmentService.updateEntry(department);
        return action2action;
    }


    public String addUI()
    {
        return addUI;
    }

    public String add(){
        Department department = new Department();
        BeanUtils.copyProperties(this.getModel(),department);
        this.departmentService.saveEntry(department);
        return action2action;
    }

    public String delete()
    {
        this.departmentService.deleteEntry(this.getModel().getDid());
        return action2action;
    }
}
