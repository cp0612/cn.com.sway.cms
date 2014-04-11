package cn.com.sway.cms.interceptor;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import cn.com.sway.cms.config.service.ConfigService;
import cn.com.sway.cms.navi.model.Navi;
import cn.com.sway.cms.navi.service.NaviService;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class GlobalInterceptor extends AbstractInterceptor{
	
	private ConfigService configService;
	
	private NaviService naviService;

	public ConfigService getConfigService() {
		return configService;
	}

	public void setConfigService(ConfigService configService) {
		this.configService = configService;
	}

	public NaviService getNaviService() {
		return naviService;
	}

	public void setNaviService(NaviService naviService) {
		this.naviService = naviService;
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		//DEBUG模式时不进行application保存(每次访问都进行对应的application清楚动作)
		if(ServletActionContext.getContext().getApplication().get("configMap")!=null){
			Map<String, String> configMap = (Map<String, String>)ServletActionContext.getContext().getApplication().get("configMap");
			if(configMap.get("debugMode").equals("1")){
				//ServletActionContext.getContext().getApplication().clear(); //这个会报"No org.apache.tomcat.InstanceManager set in ServletContext"错误
				ServletActionContext.getContext().getApplication().remove("configMap");
				ServletActionContext.getContext().getApplication().remove("naviList");
			}
		}
		
		//将config存进application
		if(ServletActionContext.getContext().getApplication().get("configMap")==null){
			Map<String, String> configMap = this.configService.getConfigMap();
			ServletActionContext.getContext().getApplication().put("configMap", configMap);
			/*for(Map.Entry config : configMap.entrySet()){
				System.out.println(config.getKey() + ":" + config.getValue());  
		    }*/
		}
		
		//将navi存进application
		if(ServletActionContext.getContext().getApplication().get("naviList")==null){
			List<Navi> naviList = this.naviService.list("FROM Navi navi WHERE navi.parent=null ORDER BY navi.orderNum ASC");
			ServletActionContext.getContext().getApplication().put("naviList", naviList);
		}
		
		return invocation.invoke();
	}

	
	
}
