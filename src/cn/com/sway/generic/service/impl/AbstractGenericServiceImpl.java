package cn.com.sway.generic.service.impl;


import java.util.List;

import cn.com.sway.generic.dao.AbstractGenericDao;
import cn.com.sway.generic.service.AbstractGenericService;

public abstract class AbstractGenericServiceImpl<M, PK> implements AbstractGenericService<M, PK> {
	
	protected AbstractGenericDao<M, PK> abstractGenericDao;
	
	public abstract void setAbstractGenericDao(AbstractGenericDao<M, PK> abstractGenericDao);

	public void save(M model){
		abstractGenericDao.save(model);
	}
	
	public void saveOrUpdate(M model){
		abstractGenericDao.saveOrUpdate(model);
	}
	
	public void update(M model){
		abstractGenericDao.update(model);
	}
	
	public void merge(M model){
		abstractGenericDao.merge(model);
	}
	
	public void delete(M model){
		abstractGenericDao.delete(model);
	}
	
	public M get(PK id){
		return abstractGenericDao.get(id);
	}
	
	public boolean exists(PK id){
		return abstractGenericDao.exists(id);
	}
	
	public List<M> listAll(){
		return abstractGenericDao.listAll();
	}
	
	public <T> List<T> list(final String sql, final Object... paramlist){
		return abstractGenericDao.list(sql, paramlist);
	}
	
	public <T> List<T> list(final String hql, final int pn, final int pageSize, final Object... paramlist){
		return abstractGenericDao.list(hql, pn, pageSize, paramlist);
	}
}
