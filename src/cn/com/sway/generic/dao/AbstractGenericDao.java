package cn.com.sway.generic.dao;

import java.util.List;

public interface AbstractGenericDao<M, PK> {
	
	//保存实体
	public void save(M model);
	
	//保存或更新实体
	public void saveOrUpdate(M model);
	
	//更新实体
	public void update(M model);
	
	//merge实体
	public void merge(M model);
	
	//删除实体
	public void delete(M model);
	
	//根据ID查找实体
	public M get(PK id);
	
	//根据ID判断实体是否存在
	public boolean exists(PK id);
	
	//获取所有实体
	public List<M> listAll();
	
	public <T> List<T> list(final String sql, final Object... paramlist);
	
	public <T> List<T> list(final String hql, final int pn, final int pageSize, final Object... paramlist);
	
	// -------------------- HSQL ----------------------------------------------
	
	
	
}
