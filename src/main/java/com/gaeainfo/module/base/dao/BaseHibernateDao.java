package com.gaeainfo.module.base.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Rock on 2016/10/26.
 */
@Repository
public class BaseHibernateDao {

    private HibernateTemplate hibernateTemplate;
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public HibernateTemplate getHibernateTemplate() {
        return this.hibernateTemplate;
    }

    public Session getSession() {
        return this.getSessionFactory().getCurrentSession();
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.hibernateTemplate = new HibernateTemplate(this.sessionFactory);
        this.hibernateTemplate.setCacheQueries(true);
    }

// -------------------- 基本检索、增加、修改、删除操作 --------------------

    // 根据主键获取实体。如果没有相应的实体，返回 null。
    public <T> T get(Class<T> clazz,    Serializable id) {
        return  hibernateTemplate.get(clazz, id);
    }

    // 根据主键获取实体。如果没有相应的实体，抛出异常。
    public <T> T load(Class<T> clazz,Serializable id) {
        return hibernateTemplate.load(clazz, id);
    }

    // 获取全部实体。
    public List loadAll(Class clazz) {
        return hibernateTemplate.loadAll(clazz);
    }

    // loadAllWithLock() ?

    // 更新实体
    public void update(Object entity) {
        hibernateTemplate.update(entity);
    }

    // 存储实体到数据库
    public void save(Object entity) {
        hibernateTemplate.save(entity);
    }

    // saveWithLock()？

    // 增加或更新实体
    public void saveOrUpdate(Object entity) {
        hibernateTemplate.saveOrUpdate(entity);
    }

    // 删除指定的实体
    public void delete(Object entity) {
        hibernateTemplate.delete(entity);
    }

    // 根据主键删除指定实体
    public void deleteByKey(Class clazz,Serializable id) {
        this.delete(this.load(clazz,id));
    }

    // -------------------- HSQL ----------------------------------------------

    // 使用HSQL语句直接增加、更新、删除实体
    public int bulkUpdate(String queryString) {
        return hibernateTemplate.bulkUpdate(queryString);
    }

    // 使用带参数的HSQL语句增加、更新、删除实体
    public int bulkUpdate(String queryString, Object[] values) {
        return hibernateTemplate.bulkUpdate(queryString, values);
    }

    // 使用HSQL语句检索数据
    public List find(String queryString) {
        return hibernateTemplate.find(queryString);
    }

    // 使用带参数的HSQL语句检索数据
    public List find(String queryString, Object[] values) {
        return hibernateTemplate.find(queryString, values);
    }

    // 使用带命名的参数的HSQL语句检索数据
    public List findByNamedParam(String queryString, String[] paramNames,
                                 Object[] values) {
        return hibernateTemplate.findByNamedParam(queryString, paramNames,
                values);
    }

    // 使用命名的HSQL语句检索数据
    public List findByNamedQuery(String queryName) {
        return hibernateTemplate.findByNamedQuery(queryName);
    }

    // 使用带参数的命名HSQL语句检索数据
    public List findByNamedQuery(String queryName, Object[] values) {
        return hibernateTemplate.findByNamedQuery(queryName, values);
    }

    // 使用带命名参数的命名HSQL语句检索数据
    public List findByNamedQueryAndNamedParam(String queryName,
                                              String[] paramNames, Object[] values) {
        return hibernateTemplate.findByNamedQueryAndNamedParam(queryName,
                paramNames, values);
    }

    // 使用HSQL语句检索数据，返回 Iterator
    public Iterator iterate(String queryString) {
        return hibernateTemplate.iterate(queryString);
    }

    // 使用带参数HSQL语句检索数据，返回 Iterator
    public Iterator iterate(String queryString, Object[] values) {
        return hibernateTemplate.iterate(queryString, values);
    }

    // 关闭检索返回的 Iterator
    public void closeIterator(Iterator it) {
        hibernateTemplate.closeIterator(it);
    }

    // -------------------------------- Criteria ------------------------------

    // 检索满足标准的数据
    public List findByCriteria(DetachedCriteria criteria) {
        return hibernateTemplate.findByCriteria(criteria);
    }

    public Object findObjByCriteria(DetachedCriteria criteria) {
        List list = hibernateTemplate.findByCriteria(criteria);
        return list.size()==0?null:list.get(0);
    }

    // 检索满足标准的数据，返回指定范围的记录
    public List findByCriteria(DetachedCriteria criteria, int firstResult,
                               int maxResults) {
        return hibernateTemplate.findByCriteria(criteria, firstResult,
                maxResults);
    }

    // 使用指定的检索标准获取满足标准的记录数
    public Integer getRowCount(DetachedCriteria criteria) {
        criteria.setProjection(Projections.rowCount());
        List list = this.findByCriteria(criteria, 0, 1);
        return ((Long) list.get(0)).intValue();
    }

    // 使用指定的检索标准检索数据，返回指定统计值(max,min,avg,sum)
    public Object getStatValue(DetachedCriteria criteria, String propertyName,
                               String StatName) {
        if (StatName.toLowerCase().equals("max"))
            criteria.setProjection(Projections.max(propertyName));
        else if (StatName.toLowerCase().equals("min"))
            criteria.setProjection(Projections.min(propertyName));
        else if (StatName.toLowerCase().equals("avg"))
            criteria.setProjection(Projections.avg(propertyName));
        else if (StatName.toLowerCase().equals("sum"))
            criteria.setProjection(Projections.sum(propertyName));
        else
            return null;
        List list = this.findByCriteria(criteria, 0, 1);
        return list.get(0);
    }

    // -------------------------------- Others --------------------------------

    // 强制初始化指定的实体
    public void initialize(Object proxy) {
        hibernateTemplate.initialize(proxy);
    }

    // 强制立即更新缓冲数据到数据库（否则仅在事务提交时才更新）
    public void flush() {
        hibernateTemplate.flush();
    }

    //--------------------------------- 原生SQL---------------------------------

    public <T> List<T> findListBySQL(final String sql,Class<T> clzss){
        ResultTransformer resultTransformer = Transformers.aliasToBean(clzss);
        return sessionFactory.getCurrentSession().createSQLQuery(sql).setResultTransformer(resultTransformer).list();

    }

    public <T> T findObjBySQL(final String sql, Class<T> clzss) {
        final ResultTransformer resultTransformer = Transformers.aliasToBean(clzss);
        List<T> list = sessionFactory.getCurrentSession().createSQLQuery(sql).setResultTransformer(resultTransformer).list();
        if (list.size() == 0) {
            return null;
        } else {
            return list.get(0);
        }
    }
}