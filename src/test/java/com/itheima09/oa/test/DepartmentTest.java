package com.itheima09.oa.test;

import org.junit.Test;

import com.itheima09.oa.domain.Department;
import com.itheima09.oa.service.DepartmentService;
import com.itheima09.oa.struts2.action.DepartmentAction;

public class DepartmentTest extends SpringUtils{
	@Test
	public void testSaveDepartment(){
		DepartmentService departmentService = (DepartmentService)context.getBean("departmentService");
		Department department = new Department();
		department.setName("公关部");
		department.setDescription("美女多");
		departmentService.saveEntry(department);
	}
	
	@Test
	public void testDepartmentAction(){
		DepartmentAction departmentAction = (DepartmentAction)context.getBean("departmentAction");
		System.out.println(departmentAction);
	}
	
	@Test
	public void testGetDeparment(){
		DepartmentService departmentService = (DepartmentService)context.getBean("departmentService");
		Department department = departmentService.getEntryById(1L);
		department.getUsers();
	}
}
