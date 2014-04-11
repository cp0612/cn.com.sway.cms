package cn.com.sway.cms.config.service;

import java.util.Map;

import cn.com.sway.cms.config.model.Config;
import cn.com.sway.generic.service.AbstractGenericService;

public interface ConfigService extends AbstractGenericService<Config, String> {

	public Map<String, String> getConfigMap();

}
