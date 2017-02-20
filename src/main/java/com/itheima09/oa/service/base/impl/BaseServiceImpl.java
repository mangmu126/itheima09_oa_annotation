package com.itheima09.oa.service.base.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.itheima09.oa.dao.base.BaseDao;
import com.itheima09.oa.service.base.BaseService;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

	public abstract BaseDao<T> getBaseDao();
		
	@Transactional
	public void saveEntry(T t) {
		this.getBaseDao().saveEntry(t);
	}

	@Transactional
	public void deleteEntry(Serializable id) {
		this.getBaseDao().deleteEntry(id);
	}

	@Transactional
	public void updateEntry(T t) {
		this.getBaseDao().updateEntry(t);
	}

	@Transactional(readOnly=true)
	public Collection<T> queryEntry() {
		// TODO Auto-generated method stub
		return this.getBaseDao().queryEntry();
	}

	@Transactional(readOnly=true)
	public T getEntryById(Serializable id) {
		return this.getBaseDao().getEntryById(id);
	}

	@Transactional(readOnly=true)
	public Set<T> getEntrysByIds(Serializable[] id) {
		// TODO Auto-generated method stub
		return this.getBaseDao().getEntrysByIds(id);
	}
	
}
