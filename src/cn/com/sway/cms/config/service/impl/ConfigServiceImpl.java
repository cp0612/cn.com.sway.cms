package cn.com.sway.cms.config.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;



import cn.com.sway.cms.config.dao.ConfigDao;
import cn.com.sway.cms.config.model.Config;
import cn.com.sway.cms.config.service.ConfigService;
import cn.com.sway.generic.dao.AbstractGenericDao;
import cn.com.sway.generic.service.impl.AbstractGenericServiceImpl;


@Service("configService")
public class ConfigServiceImpl extends AbstractGenericServiceImpl<Config, String> implements ConfigService{
	
	private ConfigDao configDao;
	
	@Autowired
    @Qualifier("configDao")
    @Override
    public void setAbstractGenericDao(AbstractGenericDao<Config, String> configDao) {
        this.abstractGenericDao = configDao;
        this.configDao = (ConfigDao) configDao;
    }

	@Override
	public Map<String, String> getConfigMap() {
		// TODO Auto-generated method stub
		return this.configDao.getConfigMap();
	}

}
