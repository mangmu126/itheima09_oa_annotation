package com.itheima09.oa.struts2.action.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import org.springframework.beans.BeanUtils;

import com.itheima09.oa.service.base.BaseService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public abstract class BaseAction<T> implements ModelDriven<T>{

	//public abstract BaseService<T> getBaseService();
	
	private Class modelDriverClass;
	private Long id;
	
	//跳转到列表页面的常量
	public static final String LISTACTION = "listAction";
	//跳转到更新页面的常量
	public static final String UPDATEUI = "updateUI";
	//跳转到增加页面的常量
	public static final String ADDUI = "addUI";
	//action跳转到action
	public static final String ACTION2ACTION = "action2action";
	
	public String listAction = LISTACTION;
	public String addUI = ADDUI;
	public String updateUI = UPDATEUI;
	public String action2action = ACTION2ACTION;
	
	public void setId(Long id) {
		this.id = id;
	}

	private T t;
	
	public BaseAction() {
		//获取 BaseAction<T>
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		//获取T的class形式
		this.modelDriverClass = (Class)type.getActualTypeArguments()[0];
		try {
			this.t = (T) this.modelDriverClass.newInstance();//为t创建对象
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@Override
	public T getModel() {
		// TODO Auto-generated method stub
		return this.t;
	}
	
	/**
	 * 查询
	 */
	public String showData(){
		//Collection<T> dataList = this.getBaseService().queryEntry();
		//System.out.println(dataList.size());
		ActionContext.getContext().put("dataList", null);
		return "list";
	}
	
	/**
	 * 跳转到增加的页面
	 */
	public String addUI(){
		return "addUI";
	}
	
	/**
	 * 增加
	 */
	public String add() throws Exception{
		Object obj = this.modelDriverClass.newInstance();
		BeanUtils.copyProperties(this.getModel(), obj);
		T t = (T)obj;
		//this.getBaseService().saveEntry(t);
		return "action2action";
	}
	
	/**
	 * 跳转到修改的页面
	 */
//	public String updateUI(){
//		//T t = this.getBaseService().getEntryById(this.id);
//		ActionContext.getContext().getValueStack().push(t);
//		return "updateUI";
//	}
}
