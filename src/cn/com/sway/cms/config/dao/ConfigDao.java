package cn.com.sway.cms.config.dao;



import java.util.Map;

import cn.com.sway.cms.config.model.Config;
import cn.com.sway.generic.dao.AbstractGenericDao;

public interface ConfigDao extends AbstractGenericDao<Config, String> {

	public Map<String, String> getConfigMap();
	
}
