package cn.com.sway.cms.config.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.ListOrderedMap;
import org.springframework.stereotype.Repository;



import cn.com.sway.cms.config.dao.ConfigDao;
import cn.com.sway.cms.config.model.Config;
import cn.com.sway.generic.dao.impl.AbstractGenericDaoImpl;

@Repository("configDao")
public class ConfigDaoImpl extends AbstractGenericDaoImpl<Config, String> implements ConfigDao {

	@Override
	public Map<String, String> getConfigMap() {
		// TODO Auto-generated method stub
		//return null;
		
		@SuppressWarnings("unchecked")
		Map<String, String> configMap = new ListOrderedMap();
		
		List<Config> configList = this.list("FROM Config config ORDER BY config.orderNum ASC");
		for(Config config : configList){
			configMap.put(config.getId(), config.getValue());
		}
		
		return configMap;
	}

}
