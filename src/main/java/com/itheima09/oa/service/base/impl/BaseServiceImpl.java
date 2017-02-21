package com.itheima09.oa.service.base.impl;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import com.itheima09.oa.dao.base.BaseDao;
import com.itheima09.oa.service.base.BaseService;

public abstract class BaseServiceImpl<T> implements BaseService<T>{
	
	//声明一个抽象方法，用于子类进行实现
	public abstract BaseDao<T> getBaseDao();

	@Transactional
	public void saveEntry(T t) {
		// TODO Auto-generated method stub
		this.getBaseDao().saveEntry(t);
	}

	@Transactional
	public void deleteEntry(Serializable id) {
		// TODO Auto-generated method stub
		this.getBaseDao().deleteEntry(id);
	}

	@Transactional
	public void updateEntry(T t) {
		// TODO Auto-generated method stub
		this.getBaseDao().updateEntry(t);
	}

	@Transactional(readOnly=true)
	public Collection<T> queryEntry() {
		// TODO Auto-generated method stub
		return this.getBaseDao().queryEntry();
	}

	@Transactional(readOnly=true)
	public T getEntryById(Serializable id) {
		// TODO Auto-generated method stub
		return this.getBaseDao().getEntryById(id);
	}
}
