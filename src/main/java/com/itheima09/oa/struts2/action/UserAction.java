package com.itheima09.oa.struts2.action;

import java.util.Collection;
import java.util.HashSet;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;

import com.itheima09.oa.domain.Department;
import com.itheima09.oa.domain.Role;
import com.itheima09.oa.domain.User;
import com.itheima09.oa.service.DepartmentService;
import com.itheima09.oa.service.RoleService;
import com.itheima09.oa.service.UserService;
import com.itheima09.oa.struts2.action.base.BaseAction;
import com.opensymphony.xwork2.ActionContext;

@Controller("userAction")
public class UserAction extends BaseAction<User>{
	@Resource(name="userService")
	private UserService userService;
	/**
	 * 引入departmetService和 roleService
	 * @return
	 */
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	@Resource(name="roleService")
	private RoleService roleService;
	
	/**
	 * 声明两个属性 
	 * did
	 * rids
	 * @return
	 */
	private Long did;
	private Long[] rids;
	
	public Long getDid() {
		return did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

	public Long[] getRids() {
		return rids;
	}

	public void setRids(Long[] rids) {
		this.rids = rids;
	}

	public String showAllUser(){
		Collection<User> userList = this.userService.getAllUser();
		/**
		 * 如果userList中有重复的元素，可以把userList变成Set
		 */
		ActionContext.getContext().put("userList", new HashSet<User>(userList));
		return listAction;
	}
	
	public String addUI(){
		Collection<Department> dList = this.departmentService.queryEntry();
		Collection<Role> roleList = this.roleService.queryEntry();
		ActionContext.getContext().put("dList", dList);
		ActionContext.getContext().put("roleList", roleList);
		return addUI;
	}
	
	public String add(){
		User user = new User();
		//基本信息的赋值
		BeanUtils.copyProperties(this.getModel(), user);
		this.userService.saveUser(user, did, rids);
		return action2action;
	}
}
