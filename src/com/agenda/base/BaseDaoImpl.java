/**
 * BaseDaoImpl.java
 * 
 * Created Date:	2009/12/10		
 * Last Update:		2009/12/10	    
 * 
 * Copyright (c) Wunderman. All Rights Reserved.
 */
package com.agenda.base;

import static org.hibernate.EntityMode.POJO;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.impl.CriteriaImpl;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.type.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.agenda.common.Pagination;
import com.agenda.base.BaseDao;
import com.agenda.common.MyBeanUtils;
import com.agenda.common.Condition;
//import com.agenda.common.Constants;
import com.agenda.common.OrderBy;
import com.agenda.common.Updater;
import com.agenda.common.Finder;
import com.agenda.common.Nullable;

/**
 * @version 1.00
 * 
 * <b>修改历史:</b><br>
 * @history 2009/12/10: 初版
 * @author wei xu
 * @peer review
 * 
 * 
 */
@Repository
public abstract class BaseDaoImpl<T extends Serializable> implements BaseDao<T> {
	protected Logger log = LoggerFactory.getLogger(getClass());
	
	
	
	protected SessionFactory sessionFactory;

	protected Finder finder;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void sessionFlush(){
		//sessionFactory.getCurrentSession().getTransaction().commit();
		getSession().flush();
	}
	
	public void sessionClear(){
		getSession().clear();
	}
	

	public T save(T entity) throws Exception {

		try {
			Assert.notNull(entity);
			getSession().save(entity);
		} catch (Exception e) {
			log.error("method:save(" + persistentClass.getSimpleName()
					+ " entity)",e);
			throw new Exception();
		}

		return entity;
	}

	public Object update(Object entity) throws Exception {

		try {
			Assert.notNull(entity);
			getSession().update(entity);
		} catch (Exception e) {
			log.error("method:update(Object entity)",e);
			throw new Exception();
		}

		return entity;
	}

	public Object saveOrUpdate(Object entity) throws Exception {

		try {
			Assert.notNull(entity);
			getSession().saveOrUpdate(entity);
		} catch (Exception e) {
			log.error("method:saveOrUpdate(Object entity)",e);
			throw new Exception();
		}

		return entity;
	}

	public Object merge(Object entity) throws Exception {

		Object o = null;
		try {
			Assert.notNull(entity);
			o = getSession().merge(entity);
		} catch (Exception e) {
			log.error("method:merge(Object entity)",e);
			throw new Exception();
		}

		return o;
	}

	public void delete(Object entity) throws Exception {

		try {
			Assert.notNull(entity);
			getSession().delete(entity);
		} catch (Exception e) {
			log.error("method:delete(Object entity)",e);
			throw new Exception();
		}

	}

	public T deleteById(Serializable id) throws Exception {

		T entity = null;
		try {
			Assert.notNull(id);
			entity = load(id);
			getSession().delete(entity);
		} catch (Exception e) {
			log.error("method:deleteById(Serializable id)",e);
			throw new Exception();
		}

		return entity;
	}

	public void updateFlagById(Serializable id, long flag)
			throws Exception {
		try {
			Assert.notNull(id);
			T entity = load(id);
			if (entity != null) {
				Field f = entity.getClass().getField("flag");
				f.setAccessible(true);
				f.setLong(entity, flag);
				update(entity);
			}
		} catch (SecurityException e) {
			log.error("method:updateFlagByid(Serializable id, long flag)",e);
			throw new Exception();
		} catch (NoSuchFieldException e) {
			log.error("method:updateFlagByid(Serializable id, long flag)",e);
			throw new Exception();
		} catch (IllegalArgumentException e) {
			log.error("method:updateFlagByid(Serializable id, long flag)",e);
			throw new Exception();
		} catch (IllegalAccessException e) {
			log.error("method:updateFlagByid(Serializable id, long flag)",e);
			throw new Exception();
		} catch (Exception e) {
			log.error("method:updateFlagByid(Serializable id, long flag)",e);
			throw new Exception();
		}
	}

	public void updateFlagByIds(Serializable[] ids, long flag)
			throws Exception {
		try {
			Assert.notNull(ids);
			for (int i = 0; i < ids.length; i++) {
				if ((i + 1) % 50 == 0) {
					getSession().flush();
					getSession().clear();
				}
				updateFlagById(ids[i], flag);
			}
		} catch (Exception e) {
			log.error("method:updateFlagByIds(Serializable[] ids, long flag)",e);
			throw new Exception();
		}
	}

	public T load(Serializable id) throws Exception {
		return load(id, false);
	}

	@SuppressWarnings("unchecked")
	public T get(Serializable id) throws Exception {
		try {
			Assert.notNull(id);
			return (T) getSession().get(getPersistentClass(), id);
		} catch (Exception e) {
			log.error("method:get(Serializable id)",e);
			throw new Exception();
		}
	}
	
	@SuppressWarnings("unchecked")
	public T getWithPessimism(Serializable id) throws Exception {
		try {
			Assert.notNull(id);
			return (T) getSession().get(getPersistentClass(), id, LockMode.UPGRADE);
		} catch (Exception e) {
			log.error("method:get(Serializable id)",e);
			throw new Exception();
		}
	}

	@SuppressWarnings("unchecked")
	public T load(Serializable id, boolean lock) throws Exception {

		T entity = null;
		try {
			Assert.notNull(id);
			if (lock) {
				entity = (T) getSession().load(getPersistentClass(), id,
						LockMode.UPGRADE);
			} else {
				entity = (T) getSession().load(getPersistentClass(), id);
			}
		} catch (Exception e) {
			log.error("method:load(Serializable id, boolean lock)",e);
			throw new Exception();
		}
		return entity;
	}

	public List<T> findAll() throws Exception {
		return findByCriteria();
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(OrderBy... orders) throws Exception {
		try {
			Criteria crit = createCriteria();
			if (orders != null) {
				for (OrderBy order : orders) {
					crit.addOrder(order.getOrder());
				}
			}
			return crit.list();
		} catch (Exception e) {
			log.error("method:findAll(OrderBy... orders)",e);
			throw new Exception();
		}
	}

	public Pagination findAll(int pageNo, int pageSize, OrderBy... orders)
			throws Exception {
		try {
			Criteria crit = createCriteria();
			return findByCriteria(crit, pageNo, pageSize, null, OrderBy
					.asOrders(orders));
		} catch (Exception e) {
			log
					.error("method:findAll(int pageNo, int pageSize, OrderBy... orders)",e);
			throw new Exception();
		}
	}

	/**
	 * 按HQL查询对象列表.
	 * 
	 * @param hql
	 *            hql语句
	 * @param values
	 *            数量可变的参数
	 */
	@SuppressWarnings("unchecked")
	public List find(String hql, Object... values) throws Exception {
		try {
			return createQuery(hql, values).list();
		} catch (Exception e) {
			log.error("method:find(String hql, Object... values)",e);
			throw new Exception();
		}
	}

	/**
	 * 按HQL查询唯一对象.
	 */
	public Object findUnique(String hql, Object... values)
			throws Exception {
		try {
			return createQuery(hql, values).uniqueResult();
		} catch (Exception e) {
			log.error("method:findUnique(String hql, Object... values)",e);
			throw new Exception();
		}
	}

	/**
	 * 按属性查找对象列表.
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByProperty(String property, Object value)
			throws Exception {
		try {
			Assert.hasText(property);
			return createCriteria(Restrictions.eq(property, value)).list();
		} catch (Exception e) {
			log.error("method:findByProperty(String property, Object value)",e);
			throw new Exception();
		}
	}

	/**
	 * 按属性查找唯一对象.
	 */
	@SuppressWarnings("unchecked")
	public T findUniqueByProperty(String property, Object value)
			throws Exception {
		try {
			Assert.hasText(property);
			Assert.notNull(value);
			return (T) createCriteria(Restrictions.eq(property, value))
					.uniqueResult();
		} catch (Exception e) {
			log
					.error("method:findUniqueByProperty(String property, Object value)",e);
			throw new Exception();
		}
	}

	public int countByProperty(String property, Object value)
			throws Exception {
		try {
			Assert.hasText(property);
			Assert.notNull(value);
			return ((Number) (createCriteria(Restrictions.eq(property, value))
					.setProjection(Projections.rowCount()).uniqueResult()))
					.intValue();
		} catch (Exception e) {
			log.error("method:countByProperty(String property, Object value)",e);
			throw new Exception();
		}
	}

	@SuppressWarnings("unchecked")
	public Pagination find(Finder finder, int pageNo, int pageSize)
			throws Exception {
		try {
			int totalCount = countQueryResult(finder);
			Pagination p = new Pagination(pageNo, pageSize, totalCount);
			if (totalCount < 1) {
				return null;
			}
			
			Query query = getSession().createQuery(finder.getOrigHql());
			finder.setParamsToQuery(query);
			query.setFirstResult(p.getFirstResult());
			query.setMaxResults(p.getPageSize());			
			List list = query.list();
			if(list!=null && list.size()>0)
				p.setList(list);
			else
				p = null;
			return p;
		} catch (Exception e) {
			log.error("method:find(Finder finder, int pageNo, int pageSize)",e);
			throw new Exception();
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> find(String sqlstr, Class clazz) throws Exception{
		try {
			
			SQLQuery sqlquery = getSession().createSQLQuery(sqlstr);
			List list = sqlquery
								.addEntity(clazz)
								.list();
			if (list != null && list.size() < 1)
				list = null;
			return list;
		} catch(Exception e) {
			log.error("method:find(Finder finder)",e);
			throw new Exception();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T> find(Finder finder) throws Exception {
		try {
			Query query = getSession().createQuery(finder.getOrigHql());
			
			finder.setParamsToQuery(query);
			
			query.setFirstResult(finder.getFirstResult());
			if (finder.getMaxResults() > 0) {
				query.setMaxResults(finder.getMaxResults());
			}
			List list = query.list();
			if(list!=null && list.size()<1)
				list = null;
			return list;
		} catch (Exception e) {
			log.error("method:find(Finder finder)",e);
			throw new Exception();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Object> findO(Finder finder) throws Exception {
		try {
			Query query = getSession().createQuery(finder.getOrigHql());
			finder.setParamsToQuery(query);
			query.setFirstResult(finder.getFirstResult());
			if (finder.getMaxResults() > 0) {
				query.setMaxResults(finder.getMaxResults());
			}
			List list = query.list();
			if(list!=null && list.size()<1)
				list = null;
			return list;
		} catch (Exception e) {
			log.error("method:find(Finder finder)",e);
			throw new Exception();
		}
	}
	
	@SuppressWarnings("unchecked")
	public Pagination findByFlag(int pageNo, int pageSize)
			throws Exception {
		return find(Finder.create("select o from "
				+ persistentClass.getSimpleName() + " o where "
				+ "o.flag= "+ 1), pageNo, pageSize);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAllByFlag() throws Exception {
		return find(Finder.create("select o from "
				+ persistentClass.getSimpleName() + " o where "
				+ "o.flag= " + 1));
	}

	@SuppressWarnings("unchecked")
	public List<T> findByEgList(T eg, boolean anyWhere, Condition[] conds,
			String... exclude) throws Exception {
		try {
			Criteria crit = getCritByEg(eg, anyWhere, conds, exclude);
			return crit.list();
		} catch (Exception e) {
			log
					.error("method:findByEgList(T eg, boolean anyWhere, Condition[] conds,String... exclude)",e);
			throw new Exception();
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> findByEgList(T eg, boolean anyWhere, Condition[] conds,
			int firstResult, int maxResult, String... exclude)
			throws Exception {
		try {
			Criteria crit = getCritByEg(eg, anyWhere, conds, exclude);
			crit.setFirstResult(firstResult);
			crit.setMaxResults(maxResult);
			return crit.list();
		} catch (Exception e) {
			log.error("method:findByEgList(T eg, boolean anyWhere, Condition[] conds,int firstResult, int maxResult, String... exclude)",e);
			throw new Exception();
		}
	}

	public Pagination findByEg(T eg, boolean anyWhere, Condition[] conds,
			int page, int pageSize, String... exclude)
			throws Exception {
		try {
			Order[] orderArr = null;
			Condition[] condArr = null;
			if (conds != null && conds.length > 0) {
				List<Order> orderList = new ArrayList<Order>();
				List<Condition> condList = new ArrayList<Condition>();
				for (Condition c : conds) {
					if (c instanceof OrderBy) {
						orderList.add(((OrderBy) c).getOrder());
					} else {
						condList.add(c);
					}
				}
				orderArr = new Order[orderList.size()];
				condArr = new Condition[condList.size()];
				orderArr = orderList.toArray(orderArr);
				condArr = condList.toArray(condArr);
			}
			Criteria crit = getCritByEg(eg, anyWhere, condArr, exclude);
			return findByCriteria(crit, page, pageSize, null, orderArr);
		} catch (Exception e) {
			log
					.error("method:findByEg(T eg, boolean anyWhere, Condition[] conds,int page, int pageSize, String... exclude)",e);
			throw new Exception();
		}
	}

	/**
	 * 根据查询函数与参数列表创建Query对象,后续可进行更多处理,辅助函数.
	 */
	protected Query createQuery(String queryString, Object... values)
			throws Exception {
		try {
			Assert.hasText(queryString);
			Query queryObject = getSession().createQuery(queryString);
			if (values != null) {
				for (int i = 0; i < values.length; i++) {
					queryObject.setParameter(i, values[i]);
				}
			}
			return queryObject;
		} catch (Exception e) {
			log
					.error("method:createQuery(String queryString, Object... values)",e);
			throw new Exception();
		}
	}

	/**
	 * 按Criterion查询对象列表.
	 * 
	 * @param criterion
	 *            数量可变的Criterion.
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Criterion... criterion)
			throws Exception {
		try {
			return createCriteria(criterion).list();
		} catch (Exception e) {
			log.error("method:findByCriteria(Criterion... criterion)",e);
			throw new Exception();
		}
	}

	@SuppressWarnings("unchecked")
	protected Pagination findByCriteria(Criteria crit, int pageNo,
			int pageSize, Projection projection, Order... orders)
			throws Exception {
		try {
			int totalCount = ((Number) crit.setProjection(
					Projections.rowCount()).uniqueResult()).intValue();
			Pagination p = new Pagination(pageNo, pageSize, totalCount);
			if (totalCount < 1) {
				p.setList(new ArrayList());
				return p;
			}
			crit.setProjection(projection);
			if (projection == null) {
				crit.setResultTransformer(Criteria.ROOT_ENTITY);
			}
			if (orders != null) {
				for (Order order : orders) {
					crit.addOrder(order);
				}
			}
			crit.setFirstResult(p.getFirstResult());
			crit.setMaxResults(p.getPageSize());
			p.setList(crit.list());
			return p;
		} catch (Exception e) {
			log
					.error("method:findByCriteria(Criteria crit, int pageNo,int pageSize, Projection projection, Order... orders)",e);
			throw new Exception();
		}
	}

	/**
	 * 通过count查询获得本次查询所能获得的对象总数.
	 * 
	 * @param finder
	 * @return
	 */
	protected int countQueryResult(Finder finder) throws Exception {
		try {
			Query query = getSession().createQuery(finder.getRowCountHql());
			System.out.println(finder.getRowCountHql());
			finder.setParamsToQuery(query);
			return ((Number) query.iterate().next()).intValue();
		} catch (Exception e) {
			log.error("method:countQueryResult(Finder finder)",e);
			throw new Exception();
		}
	}

	/**
	 * 通过count查询获得本次查询所能获得的对象总数.
	 * 
	 * @return page对象中的totalCount属性将赋值.
	 */
	@SuppressWarnings("unchecked")
	protected int countQueryResult(Criteria c) throws Exception {
		try {
			CriteriaImpl impl = (CriteriaImpl) c;
			// 先把Projection、ResultTransformer、OrderBy取出来,清空三者后再执行Count操作
			Projection projection = impl.getProjection();
			ResultTransformer transformer = impl.getResultTransformer();
			List<CriteriaImpl.OrderEntry> orderEntries = null;
			try {
				orderEntries = (List) MyBeanUtils.getFieldValue(impl,
						"orderEntries");
				MyBeanUtils
						.setFieldValue(impl, "orderEntries", new ArrayList());
			} catch (Exception e) {
				log.error("不可能抛出的异常:{}", e.getMessage());
			}
			// 执行Count查询
			int totalCount = (Integer) c.setProjection(Projections.rowCount())
					.uniqueResult();
			if (totalCount < 1) {
				return 0;
			}
			// 将之前的Projection和OrderBy条件重新设回去
			c.setProjection(projection);
			if (projection == null) {
				c.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
			}
			if (transformer != null) {
				c.setResultTransformer(transformer);
			}
			MyBeanUtils.setFieldValue(impl, "orderEntries", orderEntries);
			return totalCount;
		} catch (Exception e) {
			log.error("method:countQueryResult(Criteria c)",e);
			throw new Exception();
		}
	}

	protected Criteria getCritByEg(T bean, boolean anyWhere, Condition[] conds,
			String... exclude) throws Exception {
		try {
			Criteria crit = getSession().createCriteria(getPersistentClass());
			Example example = Example.create(bean);
			example.setPropertySelector(NOT_BLANK);
			if (anyWhere) {
				example.enableLike(MatchMode.ANYWHERE);
				example.ignoreCase();
			}
			for (String p : exclude) {
				example.excludeProperty(p);
			}
			crit.add(example);
			// 处理排序和is null字段
			if (conds != null) {
				for (Condition o : conds) {
					if (o instanceof OrderBy) {
						OrderBy order = (OrderBy) o;
						crit.addOrder(order.getOrder());
					} else if (o instanceof Nullable) {
						Nullable isNull = (Nullable) o;
						if (isNull.isNull()) {
							crit.add(Restrictions.isNull(isNull.getField()));
						} else {
							crit.add(Restrictions.isNotNull(isNull.getField()));
						}
					} else {
						// never
					}
				}
			}
			// 处理many to one查询
			ClassMetadata cm = getCmd(bean.getClass());
			String[] fieldNames = cm.getPropertyNames();
			for (String field : fieldNames) {
				Object o = cm.getPropertyValue(bean, field, POJO);
				if (o == null) {
					continue;
				}
				ClassMetadata subCm = getCmd(o.getClass());
				if (subCm == null) {
					continue;
				}
				Serializable id = subCm.getIdentifier(o, POJO);
				if (id != null) {
					Serializable idName = subCm.getIdentifierPropertyName();
					crit.add(Restrictions.eq(field + "." + idName, id));
				} else {
					crit.createCriteria(field).add(Example.create(o));
				}
			}
			return crit;
		} catch (Exception e) {
			log
					.error("method:getCritByEg(T bean, boolean anyWhere, Condition[] conds,String... exclude)",e);
			throw new Exception();
		}
	}

	public void refresh(Object entity) throws Exception {
		try {
			getSession().refresh(entity);
		} catch (Exception e) {
			log.error("method:refresh(Object entity)",e);
			throw new Exception();
		}
	}

	public Object updateDefault(Object entity) throws Exception {
		try {
			return updateByUpdater(Updater.create(entity));
		} catch (Exception e) {
			log.error("method:updateDefault(Object entity)",e);
			throw new Exception();
		}
	}

	public Object updateByUpdater(Updater updater) throws Exception {
		try {
			ClassMetadata cm = getCmd(updater.getBean().getClass());
			if (cm == null) {
				throw new RuntimeException("所更新的对象没有映射或不是实体对象");
			}
			Object bean = updater.getBean();
			Object po = getSession().load(bean.getClass(),
					cm.getIdentifier(bean, POJO));
			updaterCopyToPersistentObject(updater, po);
			return po;
		} catch (Exception e) {
			log.error("method:updateByUpdater(Updater updater)",e);
			throw new Exception();
		}
	}

	/**
	 * 将更新对象拷贝至实体对象，并处理many-to-one的更新。
	 * 
	 * @param updater
	 * @param po
	 */
	@SuppressWarnings("unchecked")
	private void updaterCopyToPersistentObject(Updater updater, Object po)
			throws Exception {
		try {
			Map map = MyBeanUtils.describe(updater.getBean());
			Set<Map.Entry<String, Object>> set = map.entrySet();
			for (Map.Entry<String, Object> entry : set) {
				String name = entry.getKey();
				Object value = entry.getValue();
				if (!updater.isUpdate(name, value)) {
					continue;
				}
				if (value != null) {
					Class valueClass = value.getClass();
					ClassMetadata cm = getCmd(valueClass);
					if (cm != null) {
						Serializable vid = cm.getIdentifier(value, POJO);
						// 如果更新的many to one的对象的id为空，则将many to one设置为null。
						if (vid != null) {
							value = getSession().load(valueClass, vid);
						} else {
							value = null;
						}
					}
				}
				try {
					PropertyUtils.setProperty(po, name, value);
				} catch (Exception e) {
					// never
					log.warn("更新对象时，拷贝属性异常", e);
					throw e;
				}
			}
		} catch (Exception e) {
			log
					.error("method:updaterCopyToPersistentObject(Updater updater, Object po)",e);
			throw new Exception();
		}
	}

	/**
	 * 根据Criterion条件创建Criteria,后续可进行更多处理,辅助函数.
	 */
	protected Criteria createCriteria(Criterion... criterions)
			throws Exception {
		try {
			Criteria criteria = getSession().createCriteria(
					getPersistentClass());
			for (Criterion c : criterions) {
				criteria.add(c);
			}
			return criteria;
		} catch (Exception e) {
			log.error("method:createCriteria(Criterion... criterions)",e);
			throw new Exception();
		}
	}

	private Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public T createNewEntiey() throws Exception {
		try {
			return getPersistentClass().newInstance();
		} catch (Exception e) {
			log.error("method:createNewEntiey()",e);
			throw new Exception();
		}
	}

	@SuppressWarnings("unchecked")
	private ClassMetadata getCmd(Class clazz) throws Exception {
		try {
			return (ClassMetadata) sessionFactory.getClassMetadata(clazz);
		} catch (Exception e) {
			log.error("method:getCmd(Class clazz)",e);
			throw new Exception();
		}
	}

	/**
	 * 根据sequence名字得到相应转换为字符的sequence值（主要针对用户和经销商ID）
	 * 
	 * @param seqName
	 * @return
	 * @throws Exception
	 */
	protected String getSequence(String seqName,int length) throws Exception {
		try {
			String oLen = "FM";
			for(int i=0;i<length;i++){
				oLen += "0";
			}
			String sql = "select to_char(" + seqName +".nextval,'" + oLen + "') from dual";
			return (String)getSession().createSQLQuery(sql).uniqueResult();
		} catch (Exception e) {
			log.error("method:getSequence(String seqName)",e);
			throw new Exception();
		}
		
	}

	public static final NotBlankPropertySelector NOT_BLANK = new NotBlankPropertySelector();

	/**
	 * 不为空的EXAMPLE属性选择方式
	 * 
	 * @author liufang
	 * 
	 */
	static final class NotBlankPropertySelector implements PropertySelector {
		private static final long serialVersionUID = 1L;

		public boolean include(Object object, String property, Type type) {
			return object != null
					&& !(object instanceof String && StringUtils
							.isBlank((String) object));
		}
	}

	// public static void main(String[] args) {
	// ClubUserDao user = new ClubUserDaoImpl();
	// System.out.println(user.getPersistentClass().getSimpleName());
	// }

}