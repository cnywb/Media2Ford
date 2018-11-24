/**
 * BaseManagerImpl<T extends Serializable>.java
 * 
 * Created Date:	2009/12/14		
 * Last Update:		2009/12/14    
 * 
 * Copyright (c) Wunderman. All Rights Reserved.
 */
package com.agenda.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.agenda.common.Finder;
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
@Transactional
public class BaseManagerImpl<T extends Serializable> implements BaseManager<T> {
	protected Logger log = LoggerFactory.getLogger(getClass());
	private BaseDao<T> dao;

	public void setDao(BaseDao<T> dao) {
		this.dao = dao;
	}
	
	

	protected BaseDao<T> getDao() {
		return this.dao;
	}

	@Transactional(readOnly = true)
	public T findById(Serializable id) throws Exception{
		return dao.get(id);
	}

	@Transactional(readOnly = true)
	public T load(Serializable id)throws Exception {
		return dao.load(id);
	}

	@Transactional(readOnly = true)
	public List<T> findAll() throws Exception{
		return dao.findAll();
	}

	@Transactional(readOnly = true)
	public Pagination findAll(int pageNo, int pageSize, OrderBy... orders)throws Exception {
		return dao.findAll(pageNo, pageSize, orders);
	}

	/**
	 * 实例查找返回列表
	 */
	@Transactional(readOnly = true)
	public List<T> find(Finder finder)throws Exception {
		return dao.find(finder);
	}
	
	@Transactional(readOnly = true)
	public Pagination find(Finder finder, int pageNo, int pageSize)throws Exception {
		return dao.find(finder,pageNo,pageSize);
	}
	
	@Transactional(readOnly = true)
	public List<T> findByEgList(T eg, boolean anywhere, Condition[] conds,
			String... exclude)throws Exception {
		return dao.findByEgList(eg, anywhere, conds, exclude);
	}

	@Transactional(readOnly = true)
	public List<T> findByEgList(T eg, boolean anywhere, String... exclude)throws Exception {
		return this.findByEgList(eg, anywhere, null, exclude);
	}

	@Transactional(readOnly = true)
	public List<T> findByEgList(T eg, Condition[] conds, String... exclude) throws Exception{
		return this.findByEgList(eg, false, conds, exclude);
	}

	@Transactional(readOnly = true)
	public List<T> findByEgList(T eg, boolean anywhere, Condition[] conds,
			int firstResult, int maxResult, String... exclude)throws Exception {
		return dao.findByEgList(eg, anywhere, conds, firstResult, maxResult,
				exclude);
	}

	@Transactional(readOnly = true)
	public List<T> findByEgList(T eg, boolean anywhere, int firstResult,
			int maxResult, String... exclude)throws Exception {
		return this.findByEgList(eg, anywhere, null, firstResult, maxResult,
				exclude);
	}

	@Transactional(readOnly = true)
	public List<T> findByEgList(T eg, Condition[] conds, int firstResult,
			int maxResult, String... exclude) throws Exception{
		return this.findByEgList(eg, false, conds, firstResult, maxResult,
				exclude);
	}

	@Transactional(readOnly = true)
	public List<T> findByEgList(T eg, String... exclude)throws Exception {
		return this.findByEgList(eg, false, null, exclude);
	}

	@Transactional(readOnly = true)
	public Pagination findByEg(T eg, boolean anywhere, Condition[] conds,
			int pageNo, int pageSize, String... exclude)throws Exception {
		return dao.findByEg(eg, anywhere, conds, pageNo, pageSize, exclude);
	}

	@Transactional(readOnly = true)
	public Pagination findByEg(T eg, boolean anywhere, int pageNo,
			int pageSize, String... exclude)throws Exception {
		return this.findByEg(eg, anywhere, null, pageNo, pageSize, exclude);
	}

	@Transactional(readOnly = true)
	public Pagination findByEg(T eg, Condition[] conds, int pageNo,
			int pageSize, String... exclude)throws Exception {
		return this.findByEg(eg, false, conds, pageNo, pageSize, exclude);
	}

	@Transactional(readOnly = true)
	public Pagination findByEg(T eg, int pageNo, int pageSize,
			String... exclude) throws Exception{
		return this.findByEg(eg, false, null, pageNo, pageSize, exclude);
	}

	@Transactional(readOnly = true)
	public Pagination findByFlag(int pageNo, int pageSize)throws Exception {
		return dao.findByFlag( pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	public List<T> findAllByFlag()throws Exception {
		return dao.findAllByFlag();
	}
	
	public Object updateByUpdater(Updater updater)throws Exception {
		return dao.updateByUpdater(updater);
	}

	public Object updateDefault(Object entity) throws Exception{
		return updateByUpdater(Updater.create(entity));
	}

	public T save(T entity) throws Exception{
		return dao.save(entity);
	}

	public T saveAndRefresh(T entity)throws Exception {
		this.save(entity);
		getDao().refresh(entity);
		return entity;
	}

	public Object saveOrUpdate(Object o)throws Exception {
		return getDao().saveOrUpdate(o);
	}

	public void delete(Object o)throws Exception {
		getDao().delete(o);
	}

	public Object update(Object o)throws Exception {
		return getDao().update(o);
	}

	public Object merge(Object o)throws Exception {
		return getDao().merge(o);
	}

	public T deleteById(Serializable id)throws Exception {
		if (id == null) {
			return null;
		}
		return dao.deleteById(id);
	}

	public List<T> deleteById(Serializable[] ids)throws Exception {
		List<T> dts = new ArrayList<T>();
		T del = null;
		if (ids != null && ids.length > 0) {
			for (Serializable id : ids) {
				del = deleteById(id);
				if (del != null) {
					dts.add(del);
				}
			}
		}
		return dts;
	}
	
	public void updateFlagById(Serializable id, long flag)throws Exception
	{
		if(id==null)
		{
			return;
		}
		dao.updateFlagById(id, flag);
	}
	
	public void updateFlagByIds(Serializable[]ids,long flag)throws Exception
	{
		if(ids==null)
		{
			return;
		}
		dao.updateFlagByIds(ids, flag);
	}

	public T get(Serializable id) throws Exception {
		return dao.get(id);
	}



	public void sessionFlush() {
		dao.sessionFlush();
	}
	
	public void sessionClear() {
		dao.sessionClear();
	}



	public T getWithPessimism(Serializable id) throws Exception {
		return dao.getWithPessimism(id);
	}

}
