package com.itheima09.oa.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.itheima09.oa.dao.base.BaseDao;

/**
 * 该类不能被实例化
 * @author zd
 *
 * @param <T>
 */
public abstract class BaseDaoImpl<T> implements BaseDao<T>{
	@Resource(name="hibernateTemplate")
	public HibernateTemplate hibernateTemplate;
	
	private Class entityClass; //实体bean的class形式
	//持久化类的 标示符的名称
	private String identifierPropertyName;
	
	/**
	 * 该init方法是由spring容器来调用的
	 * postConstruct表示在调用构造方法之后调用该方法
	 */
	@PostConstruct
	public void init(){
		/*
		 * 获取到实体bean的标示符的属性的名称
		 */
		this.identifierPropertyName = this.hibernateTemplate.getSessionFactory()
			.getClassMetadata(entityClass)
			.getIdentifierPropertyName();
	}
	
	public BaseDaoImpl(){
		//this代表具体的类的对象
		//this.getClass().getGenericSuperclass() = BaseDaoImpl<T>
		/**
		 * 如果该类被实例化，则this代表BaseDaoImpl的对象
		 *    this.getClass就是该对象的字节码的形式
		 *    this.getClass().getGenericSuperclass()代表该对象的父类即Object
		 *       所以这行代码得出的是一个Class而不是一个ParameterizedType
		 */
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		//得到参数的部分
		this.entityClass = (Class)type.getActualTypeArguments()[0];
		System.out.println(type.getRawType());//rawType=BaseDaoImpl
	}
	
	@Override
	public void saveEntry(T t) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.save(t);
	}

	@Override
	public void deleteEntry(Serializable id) {
		// TODO Auto-generated method stub
		T t = (T)this.hibernateTemplate.get(this.entityClass, id);
		this.hibernateTemplate.delete(t);
	}

	@Override
	public void updateEntry(T t) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.update(t);
	}

	@Override
	public Collection<T> queryEntry() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from "+this.entityClass.getName());
	}

	@Override
	public T getEntryById(Serializable id) {
		// TODO Auto-generated method stub
		return (T)this.hibernateTemplate.get(this.entityClass, id);
	}
	
	public Set<T> getEntrysByIds(Serializable[] ids){
		StringBuffer buffer = new StringBuffer();
		buffer.append("from "+this.entityClass.getName());
		buffer.append(" where "+this.identifierPropertyName+" in(");
		for(int i=0;i<ids.length;i++){
			if(i==ids.length-1){
				buffer.append(ids[i]);
			}else{
				buffer.append(ids[i]+",");
			}
		}
		buffer.append(")");
		return new HashSet<T>(this.hibernateTemplate.find(buffer.toString()));
	}
}
