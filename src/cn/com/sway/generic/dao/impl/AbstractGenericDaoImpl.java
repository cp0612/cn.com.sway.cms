package cn.com.sway.generic.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.lang.reflect.Field;
import cn.com.sway.generic.dao.AbstractGenericDao;
import cn.com.sway.generic.pagination.PageUtil;

@Repository
public abstract class AbstractGenericDaoImpl<M, PK> implements AbstractGenericDao<M, PK> {
	
	private final Class<M> entityClass;
    private final String HQL_LIST_ALL;
    private final String HQL_COUNT_ALL;
    private final String HQL_OPTIMIZE_PRE_LIST_ALL;
    private final String HQL_OPTIMIZE_NEXT_LIST_ALL;
    private String pkName = null;
    
    public AbstractGenericDaoImpl(){
    	this.entityClass = (Class<M>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Field[] fields = this.entityClass.getDeclaredFields();
        for(Field f : fields) {
            if(f.isAnnotationPresent(Id.class)) {
                this.pkName = f.getName();
            }
        }
    	//TODO @Entity name not null
        HQL_LIST_ALL = "from " + this.entityClass.getSimpleName() + " order by " + pkName + " desc";
        HQL_OPTIMIZE_PRE_LIST_ALL = "from " + this.entityClass.getSimpleName() + " where " + pkName + " > ? order by " + pkName + " asc";
        HQL_OPTIMIZE_NEXT_LIST_ALL = "from " + this.entityClass.getSimpleName() + " where " + pkName + " < ? order by " + pkName + " desc";
        HQL_COUNT_ALL = " select count(*) from " + this.entityClass.getSimpleName();
    }
	
	@Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    public Session getSession() {
        //事务必须是开启的(Required)，否则获取不到
        return sessionFactory.getCurrentSession();
    }
    
    @Override
	public void save(M model){
		getSession().save(model); 
	}
    
    @Override
    public void saveOrUpdate(M model){
    	getSession().saveOrUpdate(model);
    }
    
    @Override
    public void update(M model){
    	getSession().update(model);
    }
    
    @Override
    public void merge(M model){
    	getSession().merge(model);
    }
    
    @Override
    public void delete(M model){
    	getSession().delete(model);
    }
    
    public M get(PK id){
    	return (M) getSession().get(this.entityClass, (Serializable) id);
    }
	
	public boolean exists(PK id){
		return get(id) != null;
	}
    
    /**
     * 执行批处理语句.如 之间insert, update, delete 等.
     */
    
    @Override
    public List<M> listAll() {
        return list(HQL_LIST_ALL);
    	//return (List<M>)getSession().createQuery(HQL_LIST_ALL).list();
    }
    
    public <T> List<T> list(final String sql, final Object... paramlist) {
        return list(sql, -1, -1, paramlist);
    }
    
    @SuppressWarnings("unchecked")
    public <T> List<T> list(final String hql, final int pn, final int pageSize, final Object... paramlist) {
        Query query = getSession().createQuery(hql);
        setParameters(query, paramlist);
        if (pn > -1 && pageSize > -1) {
            query.setMaxResults(pageSize);
            int start = PageUtil.getPageStart(pn, pageSize);
            if (start != 0) {
                query.setFirstResult(start);
            }
        }
        if (pn < 0) {
            query.setFirstResult(0);
        }
        List<T> results = query.list();
        return results;
    }
    
    protected void setParameters(Query query, Object[] paramlist) {
        if (paramlist != null) {
            for (int i = 0; i < paramlist.length; i++) {
                if(paramlist[i] instanceof Date) {
                    //TODO 难道这是bug 使用setParameter不行？？
                    query.setTimestamp(i, (Date)paramlist[i]);
                } else {
                    query.setParameter(i, paramlist[i]);
                }
            }
        }
    }
    
}
