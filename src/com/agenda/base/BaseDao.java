/**
 * BaseDao.java
 * 
 * Created Date:	2009/12/10		
 * Last Update:		2009/12/10	    
 * 
 * Copyright (c) Wunderman. All Rights Reserved.
 */
package com.agenda.base;

import java.util.List;

import java.io.Serializable;

import com.agenda.common.Condition;
import com.agenda.common.Finder;
import com.agenda.common.OrderBy;
import com.agenda.common.Pagination;
import com.agenda.common.Updater;

/**
 * @version 1.00
 * 
 * <b>修改历史:</b><br>
 * @history 		2009/12/10: 初版 		
 * @author			wei xu      				
 * @peer review									
 * 
 *
 */
public interface BaseDao<T extends Serializable> {
	
	public void sessionFlush();
	public void sessionClear();
	/**
	 * 通过ID查找对象
	 * 
	 * @param id
	 *            记录的ID
	 * @param lock
	 *            是否锁定对象
	 * @return 实体对象
	 */
	public T load(Serializable id, boolean lock)throws Exception;

	public T get(Serializable id)throws Exception;

	public T getWithPessimism(Serializable id)throws Exception;
	/**
	 * 通过ID查找对象,不锁定对象
	 * 
	 * @param id
	 *            记录的ID
	 * @return 实体对象
	 */
	public T load(Serializable id)throws Exception;

	/**
	 * 查找所有对象
	 * 
	 * @return 对象列表
	 */
	public List<T> findAll()throws Exception;

	public List<T> findAll(OrderBy... orders)throws Exception;

	public Pagination findAll(int pageNo, int pageSize, OrderBy... orders)throws Exception;
	
	/**
	 * 按HQL查询唯一对象.
	 */
	public Object findUnique(String hql, Object... values)throws Exception;
	
	public Pagination find(Finder finder, int pageNo, int pageSize)throws Exception;
	
	public List<T> find(Finder finder)throws Exception;
	
	public Pagination findByFlag(int pageNo, int pageSize)throws Exception;

	public List<T> findAllByFlag() throws Exception;
	
	public List<Object> findO(Finder finder) throws Exception;

	/**
	 * 通过示例对象查找对象列表
	 * 
	 * @param eg
	 *            示例对象
	 * @param anyWhere
	 *            是否模糊查询，默认false。
	 * @param conds
	 *            排序和is null的字段。分别为OrderBy和String。
	 * @param exclude
	 *            需要排除的属性
	 * @return 对象列表
	 */
	public List<T> findByEgList(T eg, boolean anyWhere, Condition[] conds,
			String... exclude)throws Exception;

	public List<T> findByEgList(T eg, boolean anyWhere, Condition[] conds,
			int firstResult, int maxResult, String... exclude)throws Exception;

	public Pagination findByEg(T exampleInstance, boolean anyWhere,
			Condition[] conds, int pageNo, int pageSize, String... exclude)throws Exception;

	/**
	 * 按属性查找对象列表.
	 */
	public List<T> findByProperty(String property, Object value)throws Exception;

	/**
	 * 按属性查找唯一对象.
	 */
	public T findUniqueByProperty(String property, Object value)throws Exception;

	/**
	 * 按属性查找对象的数量
	 * 
	 * @param property
	 * @param value
	 * @return
	 */
	public int countByProperty(String property, Object value)throws Exception;

	/**
	 * 根据Updater更新对象
	 * 
	 * @param updater
	 * @return 持久化对象
	 */
	public Object updateByUpdater(Updater updater)throws Exception;

	public Object updateDefault(Object entity)throws Exception;

	/**
	 * 保存对象
	 * 
	 * @param entity
	 *            实体对象
	 * @return 实体对象
	 */
	public T save(T entity)throws Exception;

	/**
	 * 更新对象
	 * 
	 * @param entity
	 *            实体对象
	 * @return 实体对象
	 */
	public Object update(Object entity)throws Exception;

	/**
	 * 保存或更新对象
	 * 
	 * @param entity
	 *            实体对象
	 * @return 实体对象
	 */
	public Object saveOrUpdate(Object entity)throws Exception;

	/**
	 * 保存或更新对象拷贝
	 * 
	 * @param entity
	 * @return 已更新的持久化对象
	 */
	public Object merge(Object entity)throws Exception;

	/**
	 * 删除对象
	 * 
	 * @param entity
	 *            实体对象
	 */
	public void delete(Object entity)throws Exception;

	/**
	 * 根据ID删除记录
	 * 
	 * @param id
	 *            记录ID
	 */
	public T deleteById(Serializable id)throws Exception;
	
	/**
	 * 根据单个id更新状态值
	 * @param id
	 * @param flag
	 * @throws DataAccessException
	 */
	public void updateFlagById(Serializable id, long flag) throws Exception;
	
	/**
	 * 批量更新状态值
	 * @param ids
	 * @param flag
	 */
	public void updateFlagByIds(Serializable[]ids,long flag)throws Exception;
	

	/**
	 * 刷新对象
	 * 
	 * @param entity
	 */
	public void refresh(Object entity)throws Exception;

	/**
	 * 获得实体Class
	 * 
	 * @return
	 */
	public Class<T> getPersistentClass()throws Exception;

	/**
	 * 创建实体类的对象
	 * 
	 * @return
	 */
	public T createNewEntiey()throws Exception;
	
}
