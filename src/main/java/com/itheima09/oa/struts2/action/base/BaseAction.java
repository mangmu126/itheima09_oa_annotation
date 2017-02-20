package com.itheima09.oa.struts2.action.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import org.apache.commons.beanutils.BeanUtils;
import org.codehaus.jackson.map.util.BeanUtil;

import com.itheima09.oa.service.base.BaseService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public abstract class BaseAction<T> implements ModelDriven<T> {
	
	public abstract BaseService<T> getBaseService();
	private Class modelDriverClass;
	
	private Long id;
	public void setId(Long id)
	{
		this.id = id;
	}
	private T t;
	
	public BaseAction(){
		
		// 获取BaseAction<T>
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		// 获取T的Class形式
		this.modelDriverClass = (Class) type.getActualTypeArguments()[0];
		try {
			this.t = (T) this.modelDriverClass.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public T getModel() {
		
		return this.t;
	}
	
	/**
	 * 查询
	 */
	public String showDate()
	{
		Collection<T> dataList = this.getBaseService().queryEntry();
		System.out.println(dataList.size());
		ActionContext.getContext().put("dataList", dataList);
		return "list";
	}
	/**
	 * 跳转增加页面
	 */
	public String addUI()
	{
		return "addUI";
	}
	
	/**
	 * 增添加
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public String add() throws Exception
	{
		Object obj = this.modelDriverClass.newInstance();
		BeanUtils.copyProperties(this.getModel(), obj);
		T t = (T)obj;
		this.getBaseService().saveEntry(t);
		return "action2action";
	}
	
	/**
	 * 跳转到修改页面
	 */
	public String updateUI()
	{
		T t = this.getBaseService().getEntryById(this.id);
		ActionContext.getContext().getValueStack().push(t);
		return "updateUI";
	}
	
}
