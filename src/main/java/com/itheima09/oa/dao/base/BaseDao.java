package com.itheima09.oa.dao.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

public interface BaseDao<T> {
	public void saveEntry(T t);
	public void deleteEntry(Serializable id);
	public void updateEntry(T t);
	public Collection<T> queryEntry();
	public T getEntryById(Serializable id);
	public Set<T> getEntrysByIds(Serializable[] id);
	
}
