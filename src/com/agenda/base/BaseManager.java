/**
 * BaseManager<T extends Serializable>.java
 * 
 * Created Date:	2009/12/14		
 * Last Update:		2009/12/14    
 * 
 * Copyright (c) Wunderman. All Rights Reserved.
 */
package com.agenda.base;

import java.io.Serializable;
import java.util.List;

import com.agenda.common.Pagination;
import com.agenda.common.Condition;
import com.agenda.common.OrderBy;
import com.agenda.common.Updater;
/**
 * @version 1.00
 * 
 * <b>修改历史:</b><br>
 * @history 		2009/12/14: 初版 		
 * @author			wei xu      				
 * @peer review									
 * 
 *
 */
public interface BaseManager<T extends Serializable> {
	
	public void sessionFlush();
	public void sessionClear();
	/**
	 * 通过ID查找对象
	 * 
	 * @param id
	 *            记录的ID
	 * @return 实体对象
	 */
	public T findById(Serializable id)throws Exception;

	public T load(Serializable id)throws Exception;
	
	public T get(Serializable id)throws Exception;
	
	public T getWithPessimism(Serializable id)throws Exception;
 
	/**
	 * 查找所有对象
	 * 
	 * @return 对象列表
	 */
	public List<T> findAll()throws Exception;

	public Pagination findAll(int pageNo, int pageSize, OrderBy... orderBys)throws Exception;

	/**
	 * 通过示例对象查找对象列表
	 * 
	 * @param eg
	 *            示例对象
	 * @param anyWhere
	 *            是否模糊查询。默认false。
	 * @param conds
	 *            排序及is null。分别为OrderBy和String。
	 * @param exclude
	 *            排除属性
	 * @return
	 */
	public List<T> findByEgList(T eg, boolean anyWhere, Condition[] conds,
			String... exclude)throws Exception;

	public List<T> findByEgList(T eg, boolean anyWhere, String... exclude)throws Exception;

	public List<T> findByEgList(T eg, Condition[] conds, String... exclude)throws Exception;

	public List<T> findByEgList(T eg, boolean anyWhere, Condition[] conds,
			int firstResult, int maxResult, String... exclude)throws Exception;

	public List<T> findByEgList(T eg, boolean anyWhere, int firstResult,
			int maxResult, String... exclude)throws Exception;

	public List<T> findByEgList(T eg, Condition[] conds, int firstResult,
			int maxResult, String... exclude)throws Exception;

	public List<T> findByEgList(T eg, String... exclude)throws Exception;

	public Pagination findByEg(T eg, boolean anyWhere, Condition[] conds,
			int pageNo, int pageSize, String... exclude)throws Exception;

	public Pagination findByEg(T eg, boolean anyWhere, int pageNo,
			int pageSize, String... exclude)throws Exception;

	public Pagination findByEg(T eg, Condition[] conds, int pageNo,
			int pageSize, String... exclude)throws Exception;

	public Pagination findByEg(T eg, int pageNo, int pageSize,
			String... exclude)throws Exception;
	
	public Pagination findByFlag(int pageNo, int pageSize)throws Exception;

	public List<T> findAllByFlag()throws Exception;
	/**
	 * 根据Updater更新对象
	 * 
	 * @param updater
	 */
	public Object updateByUpdater(Updater updater)throws Exception;

	public Object updateDefault(Object entity)throws Exception;

	/**
	 * 保存对象
	 * 
	 * @param entity
	 *            实体对象
	 * @return 操作信息
	 */
	public T save(T entity)throws Exception;

	public Object update(Object o)throws Exception;

	public Object saveOrUpdate(Object o)throws Exception;

	public void delete(Object o)throws Exception;

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
	 * @throws Exception
	 */
	public void updateFlagById(Serializable id, long flag)throws Exception;
	
	/**
	 * 批量更新状态值
	 * @param ids
	 * @param flag
	 */
	public void updateFlagByIds(Serializable[]ids,long flag)throws Exception;

	/**
	 * 根据ID数组删除记录，当发生异常时，操作终止并回滚
	 * 
	 * @param ids
	 *            记录ID数组
	 * @return 删除的对象
	 */
	public List<T> deleteById(Serializable[] ids)throws Exception;

	/**
	 * 保存并刷新对象，避免many-to-one属性不完整
	 * 
	 * @param entity
	 */
	public T saveAndRefresh(T entity)throws Exception;
	
	

}
