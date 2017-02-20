package com.itheima09.oa.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.itheima09.oa.dao.base.BaseDao;
/**
 * 该类不能被实例化
 * @author zd
 *
 * @param <T>
 */
public class BaseDaoImpl<T> implements BaseDao<T> {
	@Resource(name="hibernateTemplate")
	public HibernateTemplate hibernateTemplate;
	
	private Class entityClass; // 实体bean的class 形式
	//持久化类的 标示符的名称
	private String identifierPropertyName;
	
	/**
	 * 该init方法是由spring容器来调用的
	 * postConstruct表示在调用构造方法之后调用该方法
	 */
	
	public BaseDaoImpl(){
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		// 得到参数部分
		this.entityClass = (Class)type.getActualTypeArguments()[0];
		
		System.out.println(type.getRawType());
	}
	
	
	@Override
	public void saveEntry(T t) {
		this.hibernateTemplate.save(t);
	}

	@Override
	public void deleteEntry(Serializable id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEntry(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<T> queryEntry() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from "+this.entityClass.getName());
	}

	@Override
	public T getEntryById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<T> getEntrysByIds(Serializable[] id) {
		// TODO Auto-generated method stub
		return null;
	}

}
