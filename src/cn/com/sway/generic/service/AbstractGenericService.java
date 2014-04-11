package cn.com.sway.generic.service;

import java.util.List;

public interface AbstractGenericService<M, PK> {
	
	public void save(M model);
	
	public void saveOrUpdate(M model);
	
	public void update(M model);
	
	public void merge(M model);
	
	public void delete(M model);
	
	public M get(PK id);
	
	public boolean exists(PK id);
	
	public List<M> listAll();
	
	public <T> List<T> list(final String sql, final Object... paramlist);
	
	public <T> List<T> list(final String hql, final int pn, final int pageSize, final Object... paramlist);
	
}
